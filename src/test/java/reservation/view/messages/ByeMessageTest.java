package reservation.view.messages;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ByeMessageTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(ByeMessage.getInstance(), ByeMessage.getInstance());
  }

  @Test
  public void returnMessage() {
    String expected = "Have a nice day!";
    TestCase.assertEquals(expected, ByeMessage.getInstance().returnMessage());
  }

  @Test
  public void testToString() {
    String expected = "ByeMessage{message='Have a nice day!'}";
    TestCase.assertEquals(expected, ByeMessage.getInstance().toString());
  }
}