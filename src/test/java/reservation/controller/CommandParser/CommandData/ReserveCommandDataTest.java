package reservation.controller.CommandParser.CommandData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.Configuration;
import reservation.controller.ReservationsService;
import reservation.model.Theater;

public class ReserveCommandDataTest {
  ReservationsService.Processor processor = new ReservationsService().new Processor();
  Theater testTheater;
  ReserveCommandData reserve;
  ReserveCommandData reserve2;
  ReserveCommandData reserve3;
  ReserveCommandData reserve4;
  String expectedString = "ReserveCommandData{numberOfSeats=0}";
  ByteArrayInputStream inputStream;
  ByteArrayOutputStream outputStream;

  @Before
  public void setUp() throws Exception {
    testTheater = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    processor.setTheater(testTheater);
    reserve = new ReserveCommandData();
    reserve2 = new ReserveCommandData();
    reserve3 = new ReserveCommandData();
    reserve4 = new ReserveCommandData();
    reserve4.setNumberOfSeats(1);
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
  }

  @After
  public void tearDown() throws Exception {
    System.setIn(System.in);
    System.setOut(System.out);
  }

  @Test
  public void getNumberOfSeats() {
    TestCase.assertEquals(Integer.valueOf(0), reserve.getNumberOfSeats());
  }

  @Test
  public void setNumberOfSeats() {
    reserve.setNumberOfSeats(5);
    TestCase.assertEquals(Integer.valueOf(5), reserve.getNumberOfSeats());
  }

  @Test
  public void executeCommand() {
    reserve.setNumberOfSeats(1);
    inputStream = new ByteArrayInputStream(("no" + System.lineSeparator() + "John").getBytes());
    System.setIn(inputStream);
    outputStream.reset();
    String expectedOutputStream = "Do you need wheelchair accessible seats?"
        + " Please respond: 'yes' / 'no'." + System.lineSeparator() + "What's your name?"
        + System.lineSeparator() + "I've reserved 1 seats for you at the Test Theater in row, "
        + "7, John." + System.lineSeparator();
    int status = reserve.executeCommand(processor);
    TestCase.assertEquals(0, status);
    TestCase.assertEquals(expectedOutputStream, outputStream.toString());
  }

  @Test
  public void testToString() {
    TestCase.assertEquals(expectedString, reserve.toString());
  }

  @Test
  public void testEqualsReflexive() {
    TestCase.assertTrue(reserve.equals(reserve));
  }

  @Test
  public void testEqualsSymmetric() {
    TestCase.assertTrue(reserve.equals(reserve2) &&
        reserve2.equals(reserve));
  }

  @Test
  public void testEqualsTransitive() {
    TestCase.assertTrue(reserve.equals(reserve2) &&
        reserve2.equals(reserve3) &&
        reserve.equals(reserve3));
  }

  @Test
  public void testEqualsConsistency() {
    // Multiple calls same output
    TestCase.assertTrue(reserve.equals(reserve));
    TestCase.assertTrue(reserve2.equals(reserve2));
    // Different number seats
    TestCase.assertFalse(reserve.equals(reserve4));
  }

  @Test
  public void testEqualsNullCase() {
    TestCase.assertFalse(reserve.equals(null));
  }

  @Test
  public void testHashCode() {
    // Non-null multiple invocations must return the same value
    TestCase.assertEquals(reserve.hashCode(), reserve.hashCode());
    TestCase.assertEquals(reserve2.hashCode(), reserve2.hashCode());

    // If equal objects, then same hashcode
    TestCase.assertEquals(reserve, reserve2);
    TestCase.assertEquals(reserve.hashCode(), reserve2.hashCode());

    // For any two non-null references, if not equal objects then different hashcode
    Integer seven = 7;
    TestCase.assertFalse(reserve.equals(seven));
    TestCase.assertNotSame(reserve.hashCode(), Integer.hashCode(seven));
  }
}