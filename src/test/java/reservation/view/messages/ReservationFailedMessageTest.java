package reservation.view.messages;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.model.Reservation;

public class ReservationFailedMessageTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(ReservationFailedMessage.getInstance(), ReservationFailedMessage.getInstance());
  }

  @Test
  public void returnMessage() {
    String expected = "Sorry, we don't have that many seats together for you.";
    TestCase.assertEquals(expected, ReservationFailedMessage.getInstance().returnMessage());
  }

  @Test
  public void testToString() {
    String expected = "ReservationFailedMessage{message='Sorry, we don't have that many seats together for you.'}";
    TestCase.assertEquals(expected, ReservationFailedMessage.getInstance().toString());
  }
}