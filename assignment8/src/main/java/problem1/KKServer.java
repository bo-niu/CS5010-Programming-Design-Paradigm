package problem1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * KKServer.java is a runnable program to start a server for this chat room.
 */
public class KKServer {

    private ConcurrentHashMap<String, KKServerThread> clientsMap;
    private ServerSocket serverSocket;
    private static final int PORT_NUMBER = 12345;

    /**
     * Main() class to initiate this KKServer.
     *
     * @param args user input set default null.
     * @throws IOException throws if fail to initiate this server.
     */
    public static void main(String[] args) throws IOException {
        new KKServer(PORT_NUMBER).run();
    }

    /**
     * KKServer class constructor.
     *
     * @param port an integer indicates the port number.
     * @throws IOException throws if fail to connect to this port and create server socket.
     */
    public KKServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.clientsMap = new ConcurrentHashMap<>();
    }

    /**
     * Main thread for this KKServer.
     *
     * @throws IOException if fails to get accepted client or open sub-thread for new accepted client.
     */
    public void run() throws IOException {
        System.out.println("Server starts running.");
        while (true) {
            // Accept the incoming request
            Socket s = serverSocket.accept();
            System.out.println("New client request received : " + s.getInetAddress().getHostAddress());
            System.out.println("Creating a new handler for this client...");

            // Create a new handler object for handling this request.
            KKServerThread kkServerThread = new KKServerThread(s, this);

            // Create a new Thread with this object.
            Thread t = new Thread(kkServerThread);

            // start the thread.
            t.start();
        }
    }

    /**
     * Returns this KKServer's clientsMap.
     *
     * @return clientsMap.
     */
    public ConcurrentHashMap<String, KKServerThread> getClientsMap() {
        return clientsMap;
    }

    /**
     * Returns this KKServer's serverSocket.
     *
     * @return serverSocket.
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

}
