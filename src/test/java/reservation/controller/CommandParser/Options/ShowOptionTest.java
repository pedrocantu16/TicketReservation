package reservation.controller.CommandParser.Options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.CommandData.ShowCommandData;

public class ShowOptionTest {
  List<String> arguments = new ArrayList<>(Arrays.asList("show"));
  List<String> argumentsNull = new ArrayList<>(Arrays.asList("done"));
  String expectedString = "ShowOption{}";

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(ShowOption.getInstance(), ShowOption.getInstance());
  }

  @Test
  public void validateArgs() {
    TestCase.assertEquals(ShowCommandData.getInstance(), ShowOption.getInstance().validateArgs(arguments));
  }

  @Test
  public void validateArgsNull() {
    TestCase.assertNull(ShowOption.getInstance().validateArgs(argumentsNull));
  }

  @Test
  public void toStringTest() {
    TestCase.assertEquals(expectedString, ShowOption.getInstance().toString());
  }
}