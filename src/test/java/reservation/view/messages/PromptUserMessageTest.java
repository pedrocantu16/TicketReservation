package reservation.view.messages;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class PromptUserMessageTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(PromptUserMessage.getInstance(), PromptUserMessage.getInstance());
  }

  @Test
  public void returnMessage() {
    String expected = "What would you like to do?";
    TestCase.assertEquals(expected, PromptUserMessage.getInstance().returnMessage());
  }

  @Test
  public void testToString() {
    String expected = "PromptUserMessage{message='What would you like to do?'}";
    TestCase.assertEquals(expected, PromptUserMessage.getInstance().toString());
  }
}