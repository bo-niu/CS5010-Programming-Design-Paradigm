package problem1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KKServerAndClientTest {

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
  private static final String hostName = "127.0.0.1";
  private static final int PORT_NUMBER = 12345;

  private KKProtocol kkProtocol;
  private KKServer kkServer;
  private KKServerThread kkServerThread;
  private Socket socket;

  @Before
  public void setUp() throws Exception {


  }


  @Test
  public void run() throws IOException, InterruptedException {

    ConcurrentHashMap<String, KKServerThread> map = new ConcurrentHashMap<String, KKServerThread>();
    kkServer = new KKServer(PORT_NUMBER);

    new Thread(new Runnable() {

      @Override
      public void run() {
        while (true)
        {
          // Accept the incoming request
          Socket s = null;
          try {
            s = kkServer.getServerSocket().accept();
          } catch (IOException e) {
            e.printStackTrace();
          }

          // Create a new handler object for handling this request.
          KKServerThread kkServerThread = null;
          try {
            kkServerThread = new KKServerThread(s, kkServer);
          } catch (IOException e) {
            e.printStackTrace();
          }

          // Create a new Thread with this object.
          Thread t = new Thread(kkServerThread);

          // start the thread.
          t.start();
        }


      }
    }).start();


    new Thread(new Runnable() {
      @Override
      public void run() {
        try (
            Socket clientSocket = new Socket(hostName, PORT_NUMBER);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream())
        ) {
          BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
          KKParser kkParser = new KKParser(dos);
          String username, fromUser;

          do {
            System.out.println("Enter your username displayed in chat room: ");
            username = "bo";
            kkParser.setUsername(username);
            kkParser.encoding("login");
            System.out.println(kkParser.decoding(dis));
          } while (!kkParser.isConnected());

          // readMessage thread
          Thread readMessage = new Thread(() -> {
            while (kkParser.isConnected()) {
              try {
                System.out.println(kkParser.decoding(dis));
              } catch (IOException e) {
                if (e.getMessage().equals("Connection reset") || e.getMessage().equals("Socket closed")){
                  kkParser.setConnected(false);
                  System.out.println("client socket closed.");
                } else {
                  e.printStackTrace();
                }
              }
            }
          });
          readMessage.start();
//          kkParser.encoding("?\n");
          Thread.sleep(10000);
          dis.close();
          dos.close();
          clientSocket.close();
          System.out.println("client closed");
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        try (
            Socket clientSocket = new Socket(hostName, PORT_NUMBER);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream())
        ) {
          KKParser kkParser = new KKParser(dos);
          String username, fromUser;

          do {
            System.out.println("Enter your username displayed in chat room: ");
            username = "niu";
            kkParser.setUsername(username);
            kkParser.encoding("login");
            System.out.println(kkParser.decoding(dis));
          } while (!kkParser.isConnected());

          // readMessage thread
          Thread readMessage = new Thread(() -> {
            while (kkParser.isConnected()) {
              try {
                System.out.println(kkParser.decoding(dis));
              } catch (IOException e) {
                if (e.getMessage().equals("Connection reset") || e.getMessage().equals("Socket closed")){
                  kkParser.setConnected(false);
                  System.out.println("client socket closed.");
                } else {
                  e.printStackTrace();
                }
              }
            }
          });
          readMessage.start();

//          System.out.println("Welcome " + username + "! Type '?' for UI options.");

          kkParser.encoding("who");
          Thread.sleep(1000);
          kkParser.encoding("@user bo hello");
          Thread.sleep(1000);
          kkParser.encoding("@all hello all");
          Thread.sleep(1000);
          kkParser.encoding("!user bo");
          Thread.sleep(1000);
          kkParser.encoding("@user nonexisted hello");
          Thread.sleep(1000);
          kkParser.encoding("!user nonexisted");
          Thread.sleep(1000);
          kkParser.encoding("logoff");
          Thread.sleep(5000);

          System.out.println("client closed");
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    Thread.sleep(10000);
  }
}