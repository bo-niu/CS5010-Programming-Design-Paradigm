package handler;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {

  private Seat seat;
  private Session session;
  @Before
  public void setUp() throws Exception {
    session = new Session("SessionA");
    seat = new Seat(false, false, false, "mySeat", "bob", 100, 5, 5, session);
  }
  @Test
  public void setForWheelchair() {
    seat.setForWheelchair(true);
    Assert.assertEquals(true, seat.isForWheelchair());
  }

  @Test
  public void setSeatName() {
    seat.setSeatName("name");
    Assert.assertEquals("name", seat.getSeatName());
  }

  @Test
  public void setPrice() {
    seat.setPrice(200);
    Assert.assertEquals(200, seat.getPrice());
  }

  @Test
  public void setRow() {
    seat.setRow(200);
    Assert.assertEquals(200, seat.getRow());
  }

  @Test
  public void setCol() {
    seat.setCol(200);
    Assert.assertEquals(200, seat.getCol());
  }

  @Test
  public void setSession() {
    Session s = new Session("sss");
    seat.setSession(s);
    Assert.assertEquals(s.getName(), seat.getSession().getName());
  }

  @Test
  public void getBookerName() {
    Assert.assertEquals("bob", seat.getBookerName());
  }

  @Test
  public void getPrice() {
    Assert.assertEquals(100, seat.getPrice());
  }

  @Test
  public void getRow() {
    Assert.assertEquals(5, seat.getRow());
  }

  @Test
  public void getCol() {
    Assert.assertEquals(5, seat.getCol());
  }


}