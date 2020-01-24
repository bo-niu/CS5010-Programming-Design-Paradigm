package problem1;

import java.io.*;
import java.net.Socket;

public class KKServerThread extends Thread {

    private Socket s;
    private KKServer kkServer;
    private DataInputStream dis;
    private DataOutputStream dos;
    private KKProtocol kkProtocol;

    // constructor
    public KKServerThread(Socket s, KKServer kkServer) throws IOException {
        this.s = s;
        this.kkServer = kkServer;
        this.dis = new DataInputStream(s.getInputStream());
        this.dos = new DataOutputStream(s.getOutputStream());
        this.kkProtocol = new KKProtocol(kkServer.getClientsMap(), dis, dos);
    }

    @Override
    public void run() {
        do {
            try {
                int identifier = dis.readInt();
                kkProtocol.processInput(identifier);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (kkProtocol.getUsername() == null);

        this.kkServer.getClientsMap().put(kkProtocol.getUsername(), this);
        System.out.println(">> New client " + kkProtocol.getUsername() + " has joined the chat room. <<");

        while (!s.isClosed()) {
            try {
                int identifier = dis.readInt();
                kkProtocol.processInput(identifier);
//                System.out.println("from client: " + kkProtocol.getUsername() + " server input: " + identifier);

            } catch (EOFException e) {
                try {
                    s.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } catch (IOException e) {
                String msg = e.getMessage();
                if (msg.equals("Connection reset") || msg.equals("Socket closed")) {
                    try {
                        s.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    e.printStackTrace();
                }
            }

        }

        System.out.println(">> Client " + kkProtocol.getUsername() + " has left the chat room. <<");
        this.kkServer.getClientsMap().remove(kkProtocol.getUsername());
    }

    public Socket getS() {
        return s;
    }

    public KKServer getKkServer() {
        return kkServer;
    }

    public DataInputStream getDataInputStream() {
        return dis;
    }

    public DataOutputStream getDataOutputStream() {
        return dos;
    }
}
