package handler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * GroupRequest class stands for a group ticket request.
 */
public class GroupRequest implements Observer {

  private String groupName;
  private String leaderName;
  private SingleRequest leader;
  private ArrayList<SingleRequest> requestList;
  private String seatString;

  /**
   * Getter of the seat string. seat string is the string form of how the whole group's seat
   * is distributed.
   *
   * @return seat string
   */
  public String getSeatString() {
    return seatString;
  }

  /**
   * Setter of the seat string.
   * @param seatString seat string
   */
  public void setSeatString(String seatString) {
    this.seatString = seatString;
  }

  /**
   * When a new action such as receiving new ticket request occurs, the seat distribution might be
   * rearranged totally, thus we must recalculate the seat string representing the new seat distribution
   * of the group.
   *
   * @return calculated seat string
   */
  public String calcSeatString() {
    StringBuffer sBuffer = new StringBuffer("");
    for (SingleRequest s : requestList){
      sBuffer.append(s.getSeat().getSeatName());
    }
    return sBuffer.toString();
  }

  /**
   * Constructor.
   *
   * @param groupName group's name
   * @param leaderName leader's name
   * @param requestList group ticket request
   */
  public GroupRequest(String groupName, String leaderName,
      ArrayList<SingleRequest> requestList) {
    this.groupName = groupName;
    this.leaderName = leaderName;
    this.requestList = requestList;
    leader = null;
    seatString = "";
  }

  /**
   * Getter of the group name.
   * @return group name
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * Setter of the group name.
   * @param groupName group name
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  /**
   * Getter of the leader's name.
   * @return leader's name.
   */
  public String getLeaderName() {
    return leaderName;
  }

  /**
   * Setter of the leader's name.
   * @param leaderName leader's name
   */
  public void setLeaderName(String leaderName) {
    this.leaderName = leaderName;
  }

  /**
   * Getter of the request list.
   *
   * @return request list
   */
  public ArrayList<SingleRequest> getRequestList() {
    return requestList;
  }

  /**
   * Setter of the request list.
   * @param requestList request list
   */
  public void setRequestList(ArrayList<SingleRequest> requestList) {
    this.requestList = requestList;
  }

  /**
   * Getter of the leader's request.
   * @return leader's request
   */
  public SingleRequest getLeader() {
    return leader;
  }

  /**
   * Setter of the leader's request.
   *
   * @param leader leader's request
   */
  public void setLeader(SingleRequest leader) {
    this.leader = leader;
  }

  /**
   * Updates when the group distribution is changed.
   *
   * @param o the observed object
   * @param arg the supplementary object
   */
  @Override
  public void update(Observable o, Object arg) {
    System.out.println("Changes received.");
  }
}
