package reservation.controller;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.CommandData.ReserveCommandData;
import reservation.controller.CommandParser.CommandData.ShowCommandData;
import reservation.controller.CommandParser.Options.ReserveOption;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;
import reservation.model.Theater;

public class ReservationsServiceTest {
  Theater testTheater;
  Theater testTheater2;
  ReservationsService.Processor processor = new ReservationsService().new Processor();
  ReserveCommandData reserveDataTest = new ReserveCommandData();
  ShowCommandData showDataTest = ShowCommandData.getInstance();
  ByteArrayInputStream inputStream;
  ByteArrayOutputStream outputStream;
  ReservationsService service = new ReservationsService();
  String theaterPrint = "1  = = = = = = = = = = " + System.lineSeparator()
      + "2  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "3  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "4  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "5  = = = = = = = = = = " + System.lineSeparator()
      + "6  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "7  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "8  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "9  _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "10 _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "11 _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "12 _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "13 _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "14 _ _ _ _ _ _ _ _ _ _ " + System.lineSeparator()
      + "15 _ _ _ _ _ _ _ _ _ _ ";
  String theaterPrintFull = "1  X X X X X X X X X X " + System.lineSeparator()
      + "2  X X X X X X X X X X " + System.lineSeparator()
      + "3  X X X X X X X X X X " + System.lineSeparator()
      + "4  X X X X X X X X X X " + System.lineSeparator()
      + "5  X X X X X X X X X = " + System.lineSeparator()
      + "6  X X X X X X X X X X " + System.lineSeparator()
      + "7  X X X X X X X X X X " + System.lineSeparator()
      + "8  X X X X X X X X X X " + System.lineSeparator()
      + "9  X X X X X X X X X X " + System.lineSeparator()
      + "10 X X X X X X X X X X " + System.lineSeparator()
      + "11 X X X X X X X X X X " + System.lineSeparator()
      + "12 X X X X X X X X X X " + System.lineSeparator()
      + "13 X X X X X X X X X X " + System.lineSeparator()
      + "14 X X X X X X X X X X " + System.lineSeparator()
      + "15 X X X X X X X X X X " + System.lineSeparator();


  @Before
  public void setUp() throws Exception {
    testTheater = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
  }

  @After
  public void tearDown() throws Exception {
    System.setIn(System.in);
    System.setOut(System.out);
  }

  @Test
  public void runServiceDone() {
    inputStream = new ByteArrayInputStream(("done" + System.lineSeparator()).getBytes());
    System.setIn(inputStream);
    String expectedOutputStream =  "What would you like to do?" + System.lineSeparator()
        + "Have a nice day!" + System.lineSeparator();
    outputStream.reset();
    service.runService(testTheater);
    TestCase.assertEquals(expectedOutputStream, outputStream.toString());
  }

  @Test
  public void runServiceShow() {
    inputStream = new ByteArrayInputStream(("show" + System.lineSeparator()
    + "done"+ System.lineSeparator()).getBytes());
    System.setIn(inputStream);
    String expectedOutputStream =  "What would you like to do?" + System.lineSeparator()
        + theaterPrint + System.lineSeparator()
        + "What would you like to do?" + System.lineSeparator()
        + "Have a nice day!" + System.lineSeparator();
    outputStream.reset();
    service.runService(testTheater);
    TestCase.assertEquals(expectedOutputStream, outputStream.toString());
  }

  @Test
  public void runServiceException() {
    inputStream = new ByteArrayInputStream(("reserve 11" + System.lineSeparator()
        + "done"+ System.lineSeparator()).getBytes());
    System.setIn(inputStream);
    String expectedOutputStream =  "What would you like to do?" + System.lineSeparator()
        + "Sorry, we don't have that many seats together for you." + System.lineSeparator()
        + System.lineSeparator()
        + "Usage:" + System.lineSeparator()
        + "reserve <number> : To reserve the specified number of seats." + System.lineSeparator()
        + "show : To display the current available seating in the theater." + System.lineSeparator()
        + "done : To shut down the system." + System.lineSeparator() + System.lineSeparator()
        + "What would you like to do?" + System.lineSeparator()
        + "Have a nice day!" + System.lineSeparator();
    outputStream.reset();
    service.runService(testTheater);
    TestCase.assertEquals(expectedOutputStream, outputStream.toString());
  }

  @Test
  public void fullTheaterExample() {
    testTheater2 = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, true, "John");
    testTheater2.reserveSeats(10, true, "John");
    processor.setTheater(testTheater2);
    reserveDataTest.setNumberOfSeats(1);
    inputStream = new ByteArrayInputStream(("no" + System.lineSeparator()
        + "John"+ System.lineSeparator()).getBytes());
    System.setIn(inputStream);
    String expectedOutputStream =  "Do you need wheelchair accessible seats?"
        + " Please respond: 'yes' / 'no'." + System.lineSeparator() + "What's your name?"
        + System.lineSeparator()
        + "Sorry, we don't have that many seats together for you." + System.lineSeparator();
    outputStream.reset();
    int result = processor.processDataObject(reserveDataTest);
    TestCase.assertEquals(0, result);
    TestCase.assertEquals(expectedOutputStream, outputStream.toString());
  }

  @Test
  public void fullTheaterExampleAccessibleRow() {
    testTheater2 = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, true, "John");
    testTheater2.reserveSeats(10, true, "John");
    processor.setTheater(testTheater2);
    reserveDataTest.setNumberOfSeats(1);
    inputStream = new ByteArrayInputStream(("yes" + System.lineSeparator()
        + "John"+ System.lineSeparator()).getBytes());
    System.setIn(inputStream);
    String expectedOutputStream =  "Do you need wheelchair accessible seats?"
        + " Please respond: 'yes' / 'no'." + System.lineSeparator() + "What's your name?"
        + System.lineSeparator()
        + "Sorry, we don't have that many seats together for you." + System.lineSeparator();
    outputStream.reset();
    int result = processor.processDataObject(reserveDataTest);
    TestCase.assertEquals(0, result);
    TestCase.assertEquals(expectedOutputStream, outputStream.toString());
  }

  @Test (expected = InvalidArgumentException.class)
  public void validateRandomAnswer() {
    testTheater2 = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    processor.setTheater(testTheater2);
    reserveDataTest.setNumberOfSeats(1);
    inputStream = new ByteArrayInputStream(("random" + System.lineSeparator()
        + "John"+ System.lineSeparator()).getBytes());
    System.setIn(inputStream);
    processor.processDataObject(reserveDataTest);
  }

  @Test
  public void fullTheaterShow() {
    testTheater2 = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(10, false, "John");
    testTheater2.reserveSeats(9, true, "John");
    testTheater2.reserveSeats(10, true, "John");
    processor.setTheater(testTheater2);
    inputStream = new ByteArrayInputStream(("yes" + System.lineSeparator()
        + "John"+ System.lineSeparator()).getBytes());
    outputStream.reset();
    int result = processor.processDataObject(showDataTest);
    TestCase.assertEquals(0, result);
    TestCase.assertEquals(theaterPrintFull, outputStream.toString());
  }

}