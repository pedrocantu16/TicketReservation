package reservation.view.messages;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AskAccessibleMessageTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(AskAccessibleMessage.getInstance(), AskAccessibleMessage.getInstance());
  }

  @Test
  public void returnMessage() {
    String expected = "Do you need wheelchair accessible seats? Please respond: 'yes' / 'no'.";
    TestCase.assertEquals(expected, AskAccessibleMessage.getInstance().returnMessage());
  }

  @Test
  public void testToString() {
    String expected = "AskAccessibleMessage{message='Do you need wheelchair accessible seats? Please respond: 'yes' / 'no'.'}";
    TestCase.assertEquals(expected, AskAccessibleMessage.getInstance().toString());
  }
}