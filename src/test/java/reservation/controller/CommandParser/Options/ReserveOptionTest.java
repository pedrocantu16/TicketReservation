package reservation.controller.CommandParser.Options;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.CommandData.DoneCommandData;
import reservation.controller.CommandParser.CommandData.ReserveCommandData;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;
import reservation.controller.SystemReservationExceptions.MissingArgumentException;
import reservation.model.Reservation;

public class ReserveOptionTest {
  List<String> arguments = new ArrayList<>(Arrays.asList("reserve", "5"));
  List<String> argumentsMissing = new ArrayList<>(Arrays.asList("reserve"));
  List<String> argumentsInvalidFormat = new ArrayList<>(Arrays.asList("reserve", "hi"));
  List<String> argumentsInvalidLarge = new ArrayList<>(Arrays.asList("reserve", "20"));
  List<String> argumentsInvalidShort = new ArrayList<>(Arrays.asList("reserve", "0"));
  List<String> argumentsNull = new ArrayList<>(Arrays.asList("done"));
  ReserveCommandData reserveCommandTest;
  String expectedString = "ReserveOption{}";

  @Before
  public void setUp() throws Exception {
    reserveCommandTest = new ReserveCommandData();
    reserveCommandTest.setNumberOfSeats(5);
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(ReserveOption.getInstance(), ReserveOption.getInstance());
  }

  @Test
  public void validateArgs() {
    TestCase.assertEquals(reserveCommandTest, ReserveOption.getInstance().validateArgs(arguments));
  }

  @Test
  public void validateArgsNull() {
    TestCase.assertNull(ReserveOption.getInstance().validateArgs(argumentsNull));
  }

  @Test (expected = MissingArgumentException.class)
  public void validateArgsMissingNumberSeats() {
    ReserveOption.getInstance().validateArgs(argumentsMissing);
  }

  @Test (expected = InvalidArgumentException.class)
  public void validateInvalidFormat() {
    ReserveOption.getInstance().validateArgs(argumentsInvalidFormat);
  }

  @Test (expected = InvalidArgumentException.class)
  public void validateLargeNumber() {
    ReserveOption.getInstance().validateArgs(argumentsInvalidLarge);
  }

  @Test (expected = InvalidArgumentException.class)
  public void validateSmallNumber() {
    ReserveOption.getInstance().validateArgs(argumentsInvalidShort);
  }

  @Test
  public void toStringTest() {
    TestCase.assertEquals(expectedString, ReserveOption.getInstance().toString());
  }
}