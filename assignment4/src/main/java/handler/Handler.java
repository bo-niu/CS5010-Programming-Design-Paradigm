package handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * Handler class process all new ticket requests.
 */
public class Handler extends Observable {

  private Position[][] positions;
  private LinkedList<SingleRequest> singleRequests;
  private LinkedList<GroupRequest> groupRequests;
  private ArrayList<Session> sessions;

  /**
   * Constructor.
   * @param positions two dimensional positions array
   * @param sessions sessions list
   */
  public Handler(Position[][] positions, ArrayList<Session> sessions) {
    this.positions = positions;
    this.sessions = sessions;
    singleRequests = new LinkedList<SingleRequest>();
    groupRequests = new LinkedList<GroupRequest>();
  }

  /**
   * create new sessions to the positions array.
   *
   * @param positions two dimensional positions array
   * @param seats session's seat array
   * @param row the upper left corner's row of the session on the positions array
   * @param col the upper left corner's column of the session on the positions array
   */
  public static void addSession(Position[][] positions, Seat[][] seats, int row, int col){

    for (int i=0;i<seats.length;i++){
      for (int j=0;j<seats[i].length;j++){
        seats[i][j].setgRow(i+row);
        seats[i][j].setgCol(j+col);
        positions[i+row][j+col] = seats[i][j];
      }
    }

  }

  /**
   * Write the current seat distribution to a txt file.
   * @param outputFileName output txt file name
   * @throws FileNotFoundException exceptions
   * @throws UnsupportedEncodingException exceptions
   */
  public void writeFile(String outputFileName) throws FileNotFoundException, UnsupportedEncodingException {
//    File file = new File(outputFileName);
    PrintStream ps = new PrintStream(outputFileName, "UTF-8");

    for (int i=0;i<positions.length;i++){
      for (int j=0;j<positions[i].length;j++){
        switch (positions[i][j].getType()){
          case SEAT:
            Seat seat = (Seat)(positions[i][j]);
            if (seat.isAvailable()){
              if (seat.isForWheelchair()){
                ps.append("& ");
              }else {
                ps.append(seat.getSession().getName() + " ");
              }

            }else if (seat.isPrinted()){
              ps.append("@ ");
            }else{
              ps.append("+ ");
            }
            break;


          case EMPTY:
            ps.append(". ");
            break;
        }
      }
      ps.append("\n");
    }

  }


  /**
   * Call this method to book a single ticket request.
   * @param singleRequest the single ticket request
   * @return true if the request is accepted
   */
  public boolean bookSingleTicket(SingleRequest singleRequest){

    this.singleRequests.add(singleRequest);
    return rearrangeTickets();
  }

  /**
   * Call this method to book a group ticket request.
   * @param groupRequest the group ticket
   * @return true if the request is accepted
   */
  public boolean bookGroupTickets(GroupRequest groupRequest){
    this.addObserver(groupRequest);
    this.groupRequests.add(groupRequest);
    return rearrangeTickets();
  }

  /**
   * Call this method to cancel a single ticket request.
   * @param singleRequest the previous single ticket request that is to be cancelled
   */
  public void cancelTickets(SingleRequest singleRequest){

    here:
    for (int i=0;i<groupRequests.size();i++){
      ArrayList<SingleRequest> arrayList = groupRequests.get(i).getRequestList();
      for (int j=0;j<arrayList.size();j++){
        SingleRequest r = arrayList.get(j);
        if (r.getName().equals(singleRequest.getName())){
          arrayList.remove(j);
          break here;
        }
      }
    }

    for (int i=0;i<singleRequests.size();i++){
      SingleRequest r = singleRequests.get(i);
      if (r.getName().equals(singleRequest.getName())){
        singleRequests.remove(i);
        break;
      }
    }

    rearrangeTickets();

  }

  /**
   * Create a boolean array with rows and cols, initialized with all false value. The array is used
   * for testing whether the newly request can be processed successfully.
   * @param rows rows of the array
   * @param cols column of the array
   * @return the created boolean array
   */
  private boolean[][] buildHelperVec(int rows, int cols){
    boolean[][] b = new boolean[rows][cols];
    for (int i=0;i<b.length;i++){
      for (int j=0;j<b[i].length;j++){
        b[i][j] = false;
      }
    }
    return b;
  }

  /**
   * Every time a new request is input, all the sessions will be cleared and the seat distribution process
   * can run. This method is used to reset the session.
   */
  private void resetSessions(){
    for (int i=0;i<sessions.size();i++){
      for (int j=0;j<sessions.get(i).getSeats().length;j++){
        for (int k=0;k<sessions.get(i).getSeats()[j].length;k++){
          if (!sessions.get(i).getSeats()[j][k].isPrinted()){
            sessions.get(i).getSeats()[j][k].setAvailable(true);
          }
        }
      }
    }
  }

  /**
   * This method is used to rearrange the seat distribution when a new request is input. The new distribution
   * can be different from the previous ones.
   * @return true if the process runs successfully, otherwise return false and the seat distribution will remain unchanged
   */
  private boolean rearrangeTickets(){

    if (!dummpRearrangeTickets()){return false;}
    resetSessions();

    int curColN = 0, curSesN = 0;
    int curColW = 0, curSesW = 0;
    for (GroupRequest g : groupRequests){


      ArrayList<SingleRequest> singleRequests = g.getRequestList();

      for (SingleRequest r : singleRequests){
        if (!r.isPrintedFlag()){
          if (r.isWheelSeatFlag()){

            here2:
            while (true){
              for (;curSesW<sessions.size();curSesW++){
                for (;curColW<sessions.get(curSesW).getSeats()[0].length;curColW++){
                  Seat seat = sessions.get(curSesW).getSeats()[0][curColW];
                  if (seat.isAvailable() && (!seat.isPrinted())){
                    seat.setAvailable(false);
                    seat.setBookerName(r.getName());
                    seat.setSingleRequest(r);
                    r.setSeat(seat);
                    break here2;
                  }
                }
                curColW = 0;
              }
            }


          }else{
            here1:
            while (true) {
              for (;curSesN<sessions.size();curSesN++){
                for (;curColN<sessions.get(curSesN).getSeats()[0].length;curColN++){
                  for (int n=1;n<sessions.get(curSesN).getSeats().length;n++){
                    Seat seat = sessions.get(curSesN).getSeats()[n][curColN];
                    if ( (!seat.isPrinted()) && seat.isAvailable()){
                      seat.setAvailable(false);
                      seat.setBookerName(r.getName());
                      seat.setSingleRequest(r);
                      r.setSeat(seat);
                      break here1;
                    }
                  }
                }
                curColN = 0;
              }
            }
          }
        }
      }
      curColN++;


    }


    for (SingleRequest r : singleRequests){
      if (r.isPrintedFlag()){continue;}
      here3:
      for (int s=0;s<sessions.size();s++){
        for (int i=0;i<sessions.get(s).getSeats().length;i++){
          for (int j=0;j<sessions.get(s).getSeats()[i].length;j++){
            Seat seat = sessions.get(s).getSeats()[i][j];
            if (seat.isPrinted()){ continue; }
            if (seat.isAvailable()){
              if (seat.isForWheelchair() && r.isWheelSeatFlag() ||
                  (!seat.isForWheelchair() && (!r.isWheelSeatFlag()))){
                seat.setAvailable(false);
                seat.setBookerName(r.getName());
                seat.setSingleRequest(r);
                r.setSeat(seat);
                break here3;
              }
            }
          }
        }
      }
    }




    checkGroupChanges();
    return true;
  }

  /**
   * When this method is called, a single ticket will be printed meaning that the seat for that specific person
   * is fixed and can no longer change.
   *
   * @param singleRequest the single ticket request that wants to be printed
   */
  public void printTicket(SingleRequest singleRequest){
    for (SingleRequest s : singleRequests){
      if (s.getName().equals(singleRequest.getName()) && s.getPhone().equals(singleRequest.getPhone())){
        s.setPrintedFlag(true);
        s.getSeat().setPrinted(true);
      }
    }
  }

  /**
   * After rearrange the seat distribution, call this method to see if the previous group's seat
   * distribution is changed or not. If it is changed, the group leader will be notified.
   */
  private void checkGroupChanges(){
    for (GroupRequest g : groupRequests){

      SingleRequest leader = g.getLeader();
      String seatString = g.calcSeatString();
      if (!seatString.equals(g.getSeatString())){
        //observe changes
        g.setSeatString(seatString);
        super.setChanged();
        super.notifyObservers(g);
      }

    }
  }

  /**
   * Create a temporary list to perform the rearrangement, return false if the rearrangement
   * failed. The purpose of such process if to prevent breaking the original good ticket distribution
   * when it is impossible to rearrange the ticket distribution.
   *
   * @return true if tickets can be rearranged.
   */
  private boolean dummpRearrangeTickets(){

    ArrayList<boolean[][]> dummySes = new ArrayList<boolean[][]>();
    for (Session s : sessions){
      Seat[][] seat = s.getSeats();
      boolean[][] b = buildHelperVec(seat.length, seat[0].length);
      dummySes.add(b);
    }
    int curColN = 0, curSesN = 0;
    int curColW = 0, curSesW = 0;
    for (GroupRequest g : groupRequests){


      ArrayList<SingleRequest> singleRequests = g.getRequestList();
      int normalSum = 0, wheelSum = 0;
      for (SingleRequest r : singleRequests){
        if (!r.isPrintedFlag()){
          if (r.isWheelSeatFlag()){
            wheelSum++;
          }else{
            normalSum++;
          }
        }
      }

      int width = 0;
      if(normalSum>0){
        int count = 0;
        here1:
        while (true) {
          for (;curSesN<sessions.size();curSesN++){
            for (;curColN<sessions.get(curSesN).getSeats()[0].length;curColN++){
              for (int n=1;n<sessions.get(curSesN).getSeats().length;n++){
                dummySes.get(curSesN)[n][curColN] = true;
                if (!sessions.get(curSesN).getSeats()[n][curColN].isPrinted()){
                  count++;
                  if (count == normalSum){
                    curColN++;
                    break here1;
                  }
                }
              }
            }
            curColN = 0;
          }
          if (curSesN == sessions.size()){
            return false;
          }
        }
      }

      if (wheelSum>0){
        int count = 0;
        here2:
        while (true){
          for (;curSesW<sessions.size();curSesW++){
            for (;curColW<sessions.get(curSesN).getSeats()[0].length;curColW++){
              count++;
              dummySes.get(curSesN)[0][curColN] = true;
              if (count == wheelSum){
                curColW++;
                break here2;
              }
            }
            curColW = 0;
          }
          if (curSesW == sessions.size()){
            return false;
          }
        }
      }

    }


    for (SingleRequest r : singleRequests){
      if (r.isPrintedFlag()){continue;}
      boolean flag = false;
      here:
      for (int s=0;s<sessions.size();s++){
        boolean[][] b = dummySes.get(s);
        for (int i=0;i<b.length;i++){
          for (int j=0;j<b.length;j++){
            if (!b[i][j]){
              Seat seat = sessions.get(s).getSeats()[i][j];
              if (r.isWheelSeatFlag() && seat.isForWheelchair()){
                b[i][j] = true;
                flag = true;
                break here;
              }else if ((!r.isWheelSeatFlag()) && (!seat.isForWheelchair())){
                b[i][j] = true;
                flag = true;
                break here;
              }
            }
          }
        }
      }
      if (!flag){
        return false;
      }
    }





    return true;
  }



}
