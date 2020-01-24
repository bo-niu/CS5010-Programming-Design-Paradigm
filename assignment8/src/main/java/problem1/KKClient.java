package problem1;

import java.io.*;
import java.net.Socket;

/**
 * KKClient.java is a runnable program as a client connecting to the existing server.
 */
public class KKClient {

    private static final String hostName = "127.0.0.1";
    private static final int PORT_NUMBER = 12345;
    private Socket clientSocket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private KKParser kkParser;
    private BufferedReader userIn;

    /**
     * Initiate the KKClient.run() in main thread.
     *
     * @param args user input set default to null.
     */
    public static void main(String[] args) {
        KKClient kkClient = new KKClient();
        kkClient.run();
    }

    /**
     * Running the program to recursively take user input and print out server output.
     */
    public void run() {

        try {
            clientSocket = new Socket(hostName, PORT_NUMBER);
            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());
            userIn = new BufferedReader(new InputStreamReader(System.in));
            kkParser = new KKParser(dos);
            String username, fromUser;

            // ask for an user-defined username and then check connecting availability.
            do {
                System.out.println("Enter your username displayed in chat room: ");
                username = userIn.readLine();
                kkParser.setUsername(username);
                kkParser.encoding("login");
                System.out.println(kkParser.decoding(dis));
            } while (!kkParser.isConnected());

            // sub-thread for printing out decoded message from server.
            Thread readMessage = new Thread(() -> {
                while (kkParser.isConnected()/*clientSocket.isClosed()*/) {
                    try {
                        System.out.println(kkParser.decoding(dis));
                    } catch (IOException e) {
                        if (e.getMessage().equals("Connection reset") || e.getMessage().equals("Socket closed")) {
                            kkParser.setConnected(false);
                        } else {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("client socket is now closed.");
                try {
                    dis.close();
                    dos.close();
                    clientSocket.close();
                    System.exit(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            readMessage.start();

            System.out.println("Welcome " + kkParser.getUsername() + "! Type '?' for UI options.");

            // main thread concurrently read and encode non-null input.
            while ((fromUser = userIn.readLine()) != null) {
                if ("?".equals(fromUser))
                    displayMenu();
                else {
                    try {
                        kkParser.encoding(fromUser);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMenu() {
        System.out.println("Main Menu: " +
                "\nlogoff: sends a DISCONNECT_MESSAGE to the server." +
                "\nwho:    sends a QUERY_CONNECTED_USERS to the server." +
                "\n@user:  sends a DIRECT_MESSAGE to the specified user to the server." +
                "\n@all:   sends a BROADCAST_MESSAGE to the server, to be sent to all users connected." +
                "\n!user:  sends a SEND_INSULT message to the server, to be sent to the specified user.");
    }
}
