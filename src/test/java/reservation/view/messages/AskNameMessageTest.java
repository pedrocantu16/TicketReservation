package reservation.view.messages;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AskNameMessageTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(AskNameMessage.getInstance(), AskNameMessage.getInstance());
  }

  @Test
  public void returnMessage() {
    String expected = "What's your name?";
    TestCase.assertEquals(expected, AskNameMessage.getInstance().returnMessage());
  }

  @Test
  public void testToString() {
    String expected = "AskNameMessage{message='What's your name?'}";
    TestCase.assertEquals(expected, AskNameMessage.getInstance().toString());
  }
}