package reservation.controller.CommandParser;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.CommandData.ReserveCommandData;
import reservation.controller.CommandParser.Options.ReserveOption;
import reservation.controller.Configuration;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;
import reservation.controller.SystemReservationExceptions.InvalidArgumentNumber;

public class CommandParserTest {
  CommandParser testParser;
  String args = "reserve 5";
  String argsExtra = "reserve 5 show";
  String argsInvalid = "reserve 5 please";
  ReserveCommandData reserveCommandTest;
  String expectedString = "CommandParser{options=[ReserveOption{}, ShowOption{}, DoneOption{}]}";

  @Before
  public void setUp() throws Exception {
    testParser = CommandParser.getInstance();
    reserveCommandTest = new ReserveCommandData();
    reserveCommandTest.setNumberOfSeats(5);
  }

  @Test
  public void parseValid() {
    TestCase.assertEquals(reserveCommandTest, testParser.parse(args));
  }

  @Test (expected = InvalidArgumentNumber.class)
  public void validateMultipleOptions() {
    testParser.parse(argsExtra);
  }

  @Test (expected = InvalidArgumentNumber.class)
  public void validateNoCleanArgs() {
    testParser.parse(argsInvalid);
  }

  @Test
  public void toStringTest() {
    TestCase.assertEquals(expectedString, testParser.toString());
  }
}