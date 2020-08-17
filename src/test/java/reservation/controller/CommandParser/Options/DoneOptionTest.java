package reservation.controller.CommandParser.Options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.CommandData.DoneCommandData;

public class DoneOptionTest {
  List<String> arguments = new ArrayList<>(Arrays.asList("done"));
  List<String> argumentsNull = new ArrayList<>(Arrays.asList("show"));
  String expectedString = "DoneOption{}";

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(DoneOption.getInstance(), DoneOption.getInstance());
  }

  @Test
  public void validateArgs() {
    TestCase.assertEquals(DoneCommandData.getInstance(), DoneOption.getInstance().validateArgs(arguments));
  }

  @Test
  public void validateArgsNull() {
    TestCase.assertNull(DoneOption.getInstance().validateArgs(argumentsNull));
  }

  @Test
  public void toStringTest() {
    TestCase.assertEquals(expectedString, DoneOption.getInstance().toString());
  }
}