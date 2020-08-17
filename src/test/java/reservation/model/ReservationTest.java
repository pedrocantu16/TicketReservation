package reservation.model;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ReservationTest {
  Reservation test;
  Reservation test2;
  Reservation test3;
  Reservation test4;
  Reservation test5;
  Reservation test6;
  Reservation test7;
  Reservation testFail;

  @Before
  public void setUp() throws Exception {
    test = new Reservation(3, 7, "John");
    test2 = new Reservation(3, 7, "John");
    test3 = new Reservation(3, 7, "John");
    test4 = new Reservation(5, 7, "John");
    test5 = new Reservation(3, 6, "John");
    test6 = new Reservation(3, 7, "Mark");
    test7 = new Reservation(5, 6, "Mark");
    testFail = new Reservation(5, 0, "Mark");
  }

  @Test
  public void getSuccess() {
    TestCase.assertTrue(test.getSuccess());
    TestCase.assertFalse(testFail.getSuccess());
  }

  @Test
  public void getSeats() {
    TestCase.assertEquals(Integer.valueOf(3), test.getSeats());
  }

  @Test
  public void getRow() {
    TestCase.assertEquals(Integer.valueOf(7), test.getRow());
  }

  @Test
  public void getName() {
    TestCase.assertEquals("John", test.getName());
  }

  @Test
  public void testToString() {
    String expected = "Reservation{seats=3, row=7, name='John'}";
    TestCase.assertEquals(expected, test.toString());
  }

  @Test
  public void testEqualsReflexive() {
    TestCase.assertTrue(test.equals(test));
  }

  @Test
  public void testEqualsSymmetric() {
    TestCase.assertTrue(test.equals(test2) &&
        test2.equals(test));
  }

  @Test
  public void testEqualsTransitive() {
    TestCase.assertTrue(test.equals(test2) &&
        test2.equals(test3) &&
        test.equals(test3));
  }

  @Test
  public void testEqualsConsistency() {
    // Multiple calls same output
    TestCase.assertTrue(test.equals(test));
    TestCase.assertTrue(test2.equals(test2));
    // Different seat
    TestCase.assertFalse(test.equals(test4));
    // Different row
    TestCase.assertFalse(test.equals(test5));
    // Different name
    TestCase.assertFalse(test.equals(test6));
    // Different all
    TestCase.assertFalse(test.equals(test7));
  }

  @Test
  public void testEqualsNullCase() {
    TestCase.assertFalse(test.equals(null));
  }

  @Test
  public void testHashCode() {
    // Non-null multiple invocations must return the same value
    TestCase.assertEquals(test.hashCode(), test.hashCode());
    TestCase.assertEquals(test2.hashCode(), test2.hashCode());

    // If equal objects, then same hashcode
    TestCase.assertEquals(test, test2);
    TestCase.assertEquals(test.hashCode(), test2.hashCode());

    // For any two non-null references, if not equal objects then different hashcode
    Integer seven = 7;
    TestCase.assertFalse(test.equals(seven));
    TestCase.assertNotSame(test.hashCode(), Integer.hashCode(seven));
  }
}