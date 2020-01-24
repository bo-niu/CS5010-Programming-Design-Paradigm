package handler;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HandlerTest {

  private Handler handler;

  @Before
  public void setUp() throws Exception {
    Position[][] positions = new Position[40][79];
    for (int i=0;i<40;i++){
      for (int j=0;j<79;j++){
        positions[i][j] = new Empty();
      }
    }

    Session sessionA = new Session("A");
    Session sessionB = new Session("B");
    Session sessionC = new Session("C");
    Session sessionD = new Session("D");
    Session sessionE = new Session("E");

    Seat[][] seatsA = createTestNewSeats(100, 20, 25, sessionA);
    Seat[][] seatsB = createTestNewSeats(100, 20, 25, sessionB);
    Seat[][] seatsC = createTestNewSeats(100, 20, 25, sessionC);

    sessionA.setSeats(seatsA);
    sessionB.setSeats(seatsB);
    sessionC.setSeats(seatsC);

    Handler.addSession(positions, seatsA, 0, 0);
    Handler.addSession(positions, seatsB, 0, 27);
    Handler.addSession(positions, seatsC, 0, 54);

    Seat[][] seatsD = createTestNewSeats(100, 20, 35, sessionD);
    Seat[][] seatsE = createTestNewSeats(100, 20, 35, sessionE);
    sessionD.setSeats(seatsD);
    sessionE.setSeats(seatsE);
    Handler.addSession(positions, seatsD, 20, 2);
    Handler.addSession(positions, seatsE, 20, 42);

    ArrayList<Session> sessions = new ArrayList<Session>();
    sessions.add(sessionA);
    sessions.add(sessionB);
    sessions.add(sessionC);
    sessions.add(sessionD);
    sessions.add(sessionE);

    handler = new Handler(positions, sessions);

    try {
      handler.writeFile("testFile/original.txt");
    }catch (FileNotFoundException | UnsupportedEncodingException e){
      System.out.println(e.toString());
    }
  }

  @Test
  public void bookSingleTicket() throws Exception {

    SingleRequest singleRequest = new SingleRequest("bo", "123", false);
    handler.bookSingleTicket(singleRequest);
    handler.writeFile("testFile/singleRequest.txt");



  }

  @Test
  public void bookGroupTickets() throws FileNotFoundException, UnsupportedEncodingException {

    String groupName = "NEU";
    String leaderName = "leader";
    ArrayList<SingleRequest> requestList = new ArrayList<>();
    for (int i=0;i<418;i++){
      SingleRequest singleRequest = new SingleRequest("bo", "123", false);
      requestList.add(singleRequest);
    }
    SingleRequest singleRequest = new SingleRequest("bo", "123", true);
    requestList.add(singleRequest);
    singleRequest = new SingleRequest("leader", "123", false);
    requestList.add(singleRequest);
    GroupRequest groupRequest = new GroupRequest(groupName, leaderName, requestList);
    groupRequest.setLeader(singleRequest);
    handler.bookGroupTickets(groupRequest);

    ArrayList<SingleRequest> requestList2 = new ArrayList<>();
    for (int i=0;i<98;i++){
      singleRequest = new SingleRequest("bo2", "1234", false);
      requestList2.add(singleRequest);
    }
    singleRequest = new SingleRequest("bo2", "1234", true);
    requestList2.add(singleRequest);
    singleRequest = new SingleRequest("leader", "123", false);
    requestList2.add(singleRequest);
    groupRequest = new GroupRequest(groupName, leaderName, requestList2);
    groupRequest.setLeader(singleRequest);
    handler.bookGroupTickets(groupRequest);
    handler.writeFile("testFile/groupRequest1.txt");


    singleRequest = new SingleRequest("tom", "123", false);
    handler.bookSingleTicket(singleRequest);
    singleRequest = new SingleRequest("ted", "123", false);
    handler.bookSingleTicket(singleRequest);
    singleRequest = new SingleRequest("dave", "123", false);
    handler.bookSingleTicket(singleRequest);



    handler.writeFile("testFile/groupRequest2.txt");


    ArrayList<SingleRequest> requestList3 = new ArrayList<>();
    for (int i=0;i<1800;i++){
      singleRequest = new SingleRequest("bo2", "1234", false);
      requestList3.add(singleRequest);
    }
    singleRequest = new SingleRequest("bo2", "1234", true);
    requestList3.add(singleRequest);
    singleRequest = new SingleRequest("leader", "123", false);
    requestList3.add(singleRequest);
    groupRequest = new GroupRequest(groupName, leaderName, requestList3);
    groupRequest.setLeader(singleRequest);
    handler.bookGroupTickets(groupRequest);
    handler.writeFile("testFile/groupRequest3.txt");
  }

  @Test
  public void cancelTickets() throws FileNotFoundException, UnsupportedEncodingException {

    for (int i=0;i<320;i++){
      SingleRequest singleRequest = new SingleRequest("bo", "123", false);
      handler.bookSingleTicket(singleRequest);
    }
    SingleRequest singleRequest = new SingleRequest("niu", "456", false);
    handler.bookSingleTicket(singleRequest);
    handler.printTicket(singleRequest);
    singleRequest = new SingleRequest("bo", "123", false);
    for (int i=0;i<320;i++){
      handler.cancelTickets(singleRequest);
    }
    handler.writeFile("testFile/cancelTickets.txt");
  }


  private Seat[][] createTestNewSeats(int price, int rowSum, int colSum, Session session){
    Seat[][] seats = new Seat[rowSum][colSum];
    for (int i=1;i<rowSum;i++){
      for (int j=0;j<colSum;j++){
        Seat seat = new Seat(true, false, false,
            "row"+Integer.toString(i+1)+"col" + Integer.toString(j+1), null, price, i, j, session);
        seats[i][j] = seat;
      }
    }
    for (int i=0;i<colSum;i++){
      Seat seat = new Seat(true, true, false,
          "row"+Integer.toString(rowSum) +"col"+ Integer.toString(i+1), null, price, rowSum-1, i, session);
      seats[0][i] = seat;
    }
    return seats;
  }
}