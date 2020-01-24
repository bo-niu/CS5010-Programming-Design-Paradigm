package problem1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * KKParser is responsible for:
 * Translating user input and writing it to client output stream;
 * Translating client input stream and writing it to user interface.
 */
public class KKParser {

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

    private DataOutputStream dos;
    private String username;
    private boolean isConnected;

    /**
     * KKParser class constructor.
     *
     * @param dos client output stream.
     */
    public KKParser(DataOutputStream dos) {
        this.username = null;
        this.dos = dos;
        this.isConnected = false;
    }

    /**
     * Returns this KKParser's username.
     *
     * @return username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets this KKParser's username to input string.
     *
     * @param username user-input string.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns this KKParser's isConnected.
     *
     * @return isConnected.
     */
    public boolean isConnected() {
        return isConnected;
    }

    /**
     * Sets this KKParser's isConnected to input boolean.
     *
     * @param connected a boolean flag indicating the connection status.
     */
    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    /**
     * Translates and write user-input string to output stream.
     * Undefined user commands will throw a new IOException.
     *
     * @param fromUser user-input string command.
     * @throws IOException an exception handles all undefined user-input string commands.
     */
    public void encoding(String fromUser) throws IOException {
        int usernameLength = username.length();
        byte[] usernameToByte = stringToBytes(username);

        String[] tokens = fromUser.split("\\s+");
        String command = tokens[0];
        String target, message;
        switch (command) {
            case "login":
                dos.writeInt(CONNECT_MESSAGE);
                dos.writeInt(usernameLength);
                dos.write(usernameToByte);
                break;
            case "logoff":
                dos.writeInt(DISCONNECT_MESSAGE);
                dos.writeInt(usernameLength);
                dos.write(usernameToByte);
                break;
            case "who":
                dos.writeInt(QUERY_CONNECTED_USERS);
                dos.writeInt(usernameLength);
                dos.write(usernameToByte);
                break;
            case "@user":
                dos.writeInt(DIRECT_MESSAGE);
                dos.writeInt(usernameLength);
                dos.write(usernameToByte);

                target = tokens[1];
                dos.writeInt(target.length());
                dos.write(stringToBytes(target));

                message = getMessage(tokens, 2);
                dos.writeInt(message.length());
                dos.write(stringToBytes(message));
                break;
            case "@all":
                dos.writeInt(BROADCAST_MESSAGE);
                dos.writeInt(usernameLength);
                dos.write(usernameToByte);

                message = getMessage(tokens, 1);
                dos.writeInt(message.length());
                dos.write(stringToBytes(message));
                break;
            case "!user":
                dos.writeInt(SEND_INSULT);
                dos.writeInt(usernameLength);
                dos.write(usernameToByte);

                target = tokens[1];
                dos.writeInt(target.length());
                dos.write(stringToBytes(target));
                break;
            default:
                throw new IOException("Invalid command " + command + ". Type '?' for UI options");
        }
    }

    /**
     * Translates and write server message from client input stream to client user interface.
     * Server message in incorrect format will throw IOException.
     *
     * @param dis client input stream.
     * @return a string translated from server message.
     * @throws IOException an exception handles all server messages that have incorrect formats.
     */
    public String decoding(DataInputStream dis) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int identifier = dis.readInt();
        switch (identifier) {
            case CONNECT_RESPONSE:
                setConnected(dis.readBoolean());
                stringBuilder.append("Connect request is ");
                stringBuilder.append(isConnected ? "success. " : "fail. ");
                stringBuilder.append(readString(dis, dis.readInt()));
                break;
            case DISCONNECT_RESPONSE:
                boolean b = dis.readBoolean();
                setConnected(!b);
                stringBuilder.append("Disconnect request is ");
                stringBuilder.append(isConnected ? "fail. " : "success. ");
                stringBuilder.append(readString(dis, dis.readInt()));
                break;
            case QUERY_USER_RESPONSE:
                int count = dis.readInt();
                stringBuilder.append("There are ").append(count).append(" connected users: [");
                if (count > 0) {
                    String[] usernameList = new String[count];
                    for (int i = 0; i < count; i++) {
                        usernameList[i] = readString(dis, dis.readInt());
                    }
                    stringBuilder.append(getMessage(usernameList, 0));
                }
                stringBuilder.append("]");
                break;
            case BROADCAST_MESSAGE:
                stringBuilder.append(readString(dis, dis.readInt()));
                stringBuilder.append(":");
                stringBuilder.append(readString(dis, dis.readInt()));
                break;
            case DIRECT_MESSAGE:
            case SEND_INSULT:
                stringBuilder.append(readString(dis, dis.readInt()));
                stringBuilder.append(" -> ");
                stringBuilder.append(readString(dis, dis.readInt()));
                stringBuilder.append(":");
                stringBuilder.append(readString(dis, dis.readInt()));
                break;
            case FAILED_MESSAGE:
                stringBuilder.append(readString(dis, dis.readInt()));
                break;
        }
        return stringBuilder.toString();
    }

    /**
     * Helper method that extracts a complete sentence from a string array starting at given offset.
     * This method is used to get the user-input direct or broadcast message.
     *
     * @param tokens a string array.
     * @param offset an integer indicates the index of start token in the array.
     * @return a readable string.
     */
    private String getMessage(String[] tokens, Integer offset) {
        List<String> strings = new ArrayList<>(Arrays.asList(tokens).subList(offset, tokens.length));
        return String.join(" ", strings);
    }

    /**
     * Helper method that converts string to bytes in UTF_8 format.
     *
     * @param response a string type user-input message.
     * @return an array of byte converted from input string.
     */
    private byte[] stringToBytes(String response) {
        return response.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Helper method that reads given numbers of byte from client input stream and converts it to a string.
     *
     * @param dis    client input stream.
     * @param length an integer indicates numbers of byte being read.
     * @return a string converted from an array of bytes read from input stream.
     * @throws IOException if unable to read given length of bytes.
     */
    private String readString(DataInputStream dis, int length) throws IOException {
        byte[] bytes = new byte[length];
        dis.readFully(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
