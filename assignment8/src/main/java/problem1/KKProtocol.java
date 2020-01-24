package problem1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import assignment7.*;
import org.json.simple.parser.ParseException;

/**
 * KKProtocol is responsible for reading input stream for each identifier and writing corresponding response.
 */
public class KKProtocol {

    private static final int CONNECT_MESSAGE = 19;
    private static final int CONNECT_RESPONSE = 20;
    private static final int DISCONNECT_MESSAGE = 21;
    private static final int QUERY_CONNECTED_USERS = 22;
    private static final int QUERY_USER_RESPONSE = 23;
    private static final int BROADCAST_MESSAGE = 24;
    private static final int DIRECT_MESSAGE = 25;
    private static final int FAILED_MESSAGE = 26;
    private static final int SEND_INSULT = 27;
    private static final int DISCONNECT_RESPONSE = 28;

    private ConcurrentHashMap<String, KKServerThread> clientMap;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String username;

    /**
     * KKProtocol class constructor.
     *
     * @param clientMap a ConcurrentHashMap contains all info on connected clients.
     * @param dis       server input stream.
     * @param dos       server output stream.
     */
    public KKProtocol(ConcurrentHashMap<String, KKServerThread> clientMap, DataInputStream dis, DataOutputStream dos) {
        this.clientMap = clientMap;
        this.dis = dis;
        this.dos = dos;
        this.username = null;
    }

    /**
     * Returns this KKProtocol's username.
     *
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets this KKProtocol's username to input string.
     *
     * @param username a string representing username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Processes given identifier and write corresponding response based on given chat room protocol.
     *
     * @param identifier an integer representing message type based on given chat room protocol.
     * @throws IOException handles all messages that in incorrect format.
     */
    public void processInput(int identifier) throws IOException {
        String response;
        switch (identifier) {
            case CONNECT_MESSAGE:
                synchronized (dos) {
                    dos.writeInt(CONNECT_RESPONSE);
                    response = processNewConnect();
                    dos.writeBoolean(checkConnect(response));
                    dos.writeInt(response.length());
                    dos.write(stringToBytes(response));
                }
                break;
            case DISCONNECT_MESSAGE:
                synchronized (dos) {
                    dos.writeInt(DISCONNECT_RESPONSE);
                    response = processDisconnectMessage();
                    boolean isDisconnect = checkDisconnect(response);
                    dos.writeBoolean(isDisconnect);
                    dos.writeInt(response.length());
                    dos.write(stringToBytes(response));
                    if (isDisconnect)
                        clientMap.get(username).getS().close();
                }
                break;
            case QUERY_CONNECTED_USERS:
                synchronized (dos) {
                    dos.writeInt(QUERY_USER_RESPONSE);
                    List<String> strings = processQueryUserConnected();
                    dos.writeInt(strings.size());
                    for (String string : strings) {
                        dos.writeInt(string.length());
                        dos.write(stringToBytes(string));
                    }
                }
                break;
            case DIRECT_MESSAGE:
                response = processDirectMessage();
                boolean checkDirect = checkMessage(response);
                if (checkDirect) {
                    int firstSpace = response.indexOf(" ");
                    String receiver = response.substring(0, firstSpace);
                    String message = response.substring(firstSpace);
                    DataOutputStream targetDos = this.clientMap.get(receiver).getDataOutputStream();
                    synchronized (targetDos) {
                        targetDos.writeInt(DIRECT_MESSAGE);
                        targetDos.writeInt(username.length());
                        targetDos.write(stringToBytes(username));
                        targetDos.writeInt(receiver.length());
                        targetDos.write(stringToBytes(receiver));
                        targetDos.writeInt(message.length());
                        targetDos.write(stringToBytes(message));
                    }
                } else {
                    synchronized (dos) {

                        dos.writeInt(FAILED_MESSAGE);
                        dos.writeInt(response.length());
                        dos.write(stringToBytes(response));
                    }
                }
                break;
            case BROADCAST_MESSAGE:
                response = processBroadcastMessage();
                boolean checkBroadcast = checkMessage(response);
                if (checkBroadcast) {
                    for (String name : this.clientMap.keySet()) {
                        if (!name.equals(username)) {
                            DataOutputStream targetDos = this.clientMap.get(name).getDataOutputStream();
                            synchronized (targetDos) {
                                targetDos.writeInt(BROADCAST_MESSAGE);
                                targetDos.writeInt(username.length());
                                targetDos.write(stringToBytes(username));
                                targetDos.writeInt(response.length());
                                targetDos.write(stringToBytes(response));
                            }
                        }
                    }
                } else {
                    synchronized (dos) {
                        dos.writeInt(FAILED_MESSAGE);
                        dos.writeInt(response.length());
                        dos.write(stringToBytes(response));
                    }
                }
                break;
            case SEND_INSULT:
                response = processSendInsult();
                boolean checkInsult = checkMessage(response);
                if (checkInsult) {
                    int firstSpace = response.indexOf(" ");
                    String receiver = response.substring(0, firstSpace);
                    String message = response.substring(firstSpace);
                    DataOutputStream targetDos = this.clientMap.get(receiver).getDataOutputStream();
                    synchronized (targetDos) {
                        targetDos.writeInt(SEND_INSULT);
                        targetDos.writeInt(username.length());
                        targetDos.write(stringToBytes(username));
                        targetDos.writeInt(receiver.length());
                        targetDos.write(stringToBytes(receiver));
                        targetDos.writeInt(message.length());
                        targetDos.write(stringToBytes(message));
                    }
                } else {
                    synchronized (dos) {
                        dos.writeInt(FAILED_MESSAGE);
                        dos.writeInt(response.length());
                        dos.write(stringToBytes(response));
                    }
                }
                break;
            default:
                cleanup();
                break;
        }
    }

    /**
     * Helper method used to clean up input stream.
     *
     * @throws IOException throws when fail to read all bytes in input stream.
     */
    private void cleanup() throws IOException {
        int size = dis.available();
        dis.readFully(new byte[size]);
    }

    /**
     * Checks if connecting to server is successful.
     *
     * @param response a string representing server response according to chat room protocol.
     * @return true if and only if connecting is success; otherwise, return false.
     */
    private Boolean checkConnect(String response) {
        String[] tokens = response.split("\\s+");
        return tokens[0].equals("There");
    }

    /**
     * Checks if disconnecting to server is successful.
     *
     * @param response a string representing server response according to chat room protocol.
     * @return true if and only if disconnecting is success; otherwise, return false.
     */
    private Boolean checkDisconnect(String response) {
        String[] tokens = response.split("\\s+");
        return tokens[0].equals("Bye!");
    }

    /**
     * Checks if message being sent is valid.
     *
     * @param response a string representing server response according to chat room protocol.
     * @return true if and only if message being sent is valid; otherwise, return false.
     */
    private Boolean checkMessage(String response) {
        String[] tokens = response.split("\\s+");
        return !tokens[0].equals("Failed:");
    }

    /**
     * Converts server response to a byte array.
     *
     * @param response a string representing server response according to chat room protocol.
     * @return a byte array of input string.
     */
    private byte[] stringToBytes(String response) {
        return response.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Helper method that reads given numbers of byte from client input stream and converts it to a string
     *
     * @param length an integer indicates numbers of byte being read.
     * @param name   a string represents the string name.
     * @return a string converted from an array of bytes read from input stream.
     * @throws KKProtocolException throws if incorrect length being given.
     */
    private String readString(int length, String name) throws KKProtocolException {
        try {
            byte[] bytes = new byte[length];
            dis.readFully(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new KKProtocolException("Failed: Incorrect length for input " + name + ".");
        }
    }

    /**
     * Helper method that represents the protocol for CONNECT_MESSAGE.
     *
     * @return a string represents the server response.
     */
    private String processNewConnect() {
        try {
            String username = readString(dis.readInt(), "username");
            if (this.clientMap.containsKey(username))
                return "Username already be used.";
            else {
                int size = this.clientMap.size();
                if (size < 10) {
                    setUsername(username);
                    return "There are " + size + " other connected clients.";
                }
                return "Chat room is full. Retry later.";
            }
        } catch (IOException e) {
            return "The format of CONNECT_MESSAGE is incorrect. ";
        } catch (KKProtocolException e) {
            return e.getMessage();
        }
    }

    /**
     * Helper method that represents the protocol for DISCONNECT_MESSAGE.
     *
     * @return a string represents the server response.
     */
    private String processDisconnectMessage() {
        try {
            String username = readString(dis.readInt(), "sender");
            if (!this.clientMap.containsKey(username))
                return "Non-exist username, or already disconnected.";
            return "Bye! " + username + "! You are no longer connected.";
        } catch (IOException e) {
            return "The format of DISCONNECT_MESSAGE is incorrect.";
        } catch (KKProtocolException e) {
            return e.getMessage();
        }
    }

    /**
     * Helper method that represents the protocol for QUERY_CONNECTED_USER.
     *
     * @return a string list represents the server response.
     */
    private List<String> processQueryUserConnected() {
        List<String> responseList = new ArrayList<>();
        try {
            String username = readString(dis.readInt(), "sender");
            if (!this.clientMap.containsKey(username))
                responseList.add("Non-exist username.");
            else {
                for (String name : this.clientMap.keySet()) {
                    if (!name.equals(username))
                        responseList.add(name);
                }
            }
        } catch (IOException e) {
            responseList.add("The format of DISCONNECT_MESSAGE is incorrect.");
        } catch (KKProtocolException e) {
            responseList.add(e.getMessage());
        }
        return responseList;
    }

    /**
     * Helper method that represents the protocol for DIRECT_MESSAGE.
     *
     * @return a string represents the server response.
     */
    private String processDirectMessage() {
        try {
            String username = readString(dis.readInt(), "username");
            if (!this.clientMap.containsKey(username))
                return "Failed: Non-existed username " + username + ".";

            String target = readString(dis.readInt(), "target");
            if (!this.clientMap.containsKey(target))
                return "Failed: Non-existed target username " + target + ".";
            else {
                String message = readString(dis.readInt(), "message");
                return target + " " + message;
            }
        } catch (IOException e) {
            return "Failed: The format of DIRECT_MESSAGE is incorrect.";
        } catch (KKProtocolException e) {
            return e.getMessage();
        }
    }

    /**
     * Helper method that represents the protocol for BROADCAST_MESSAGE.
     *
     * @return a string represents the server response.
     */
    private String processBroadcastMessage() {
        try {
            String username = readString(dis.readInt(), "username");
            if (!this.clientMap.containsKey(username))
                return "Failed: Non-existed username " + username + ".";
            return readString(dis.readInt(), "message");
        } catch (IOException e) {
            return "Failed: The format of BROADCAST_MESSAGE is incorrect.";
        } catch (KKProtocolException e) {
            return e.getMessage();
        }
    }

    /**
     * Helper method that represents the protocol for SEND_INSULT.
     *
     * @return a string represents the server response.
     */
    private String processSendInsult() {
        try {
            String username = readString(dis.readInt(), "username");
            if (!this.clientMap.containsKey(username))
                return "Failed: Non-existed username " + username + ".";

            String target = readString(dis.readInt(), "target");
            if (!this.clientMap.containsKey(target))
                return "Failed: Non-existed target username " + target + ".";
            else {
                String message = RSGInsult();
                return target + " " + message;
            }
        } catch (IOException e) {
            return "Failed: The format of SEND_INSULT is incorrect.";
        } catch (KKProtocolException e) {
            return e.getMessage();
        }
    }

    /**
     * Helper method that utilizes A7 to randomly generates an insult from insult_grammar.
     *
     * @return a insult string represents the server response.
     */
    private String RSGInsult() {
        String insultMessage = "";
        try {
            ReadGrammar readGrammar = new ReadGrammar("src/main/resources/insult_grammar.json");
            Grammar insult = new Grammar(readGrammar.load());
            String start = insult.getProduction("start");
            Expression expression = new NonTerminalExpression(start);
            insultMessage = expression.interpreter(insult);
        } catch (IOException | ParseException | UndefinedNonTerminalException e) {
            e.printStackTrace();
        }
        return insultMessage;
    }
}
