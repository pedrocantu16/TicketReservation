package reservation.view.messages;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ReservationSuccessMessageTest {
  ReservationSuccessMessage test;
  ReservationSuccessMessage test2;
  ReservationSuccessMessage test3;
  ReservationSuccessMessage test4;
  ReservationSuccessMessage test5;
  ReservationSuccessMessage test6;
  ReservationSuccessMessage test7;
  ReservationSuccessMessage test8;

  @Before
  public void setUp() throws Exception {
    test = new ReservationSuccessMessage("John", 3, "NEU Cinema", 7);
    test2 = new ReservationSuccessMessage("John", 3, "NEU Cinema", 7);
    test3 = new ReservationSuccessMessage("John", 3, "NEU Cinema", 7);
    test4 = new ReservationSuccessMessage("Mark", 3, "NEU Cinema", 7);
    test5 = new ReservationSuccessMessage("John", 5, "NEU Cinema", 7);
    test6 = new ReservationSuccessMessage("John", 3, "MM Cinema", 7);
    test7 = new ReservationSuccessMessage("John", 3, "NEU Cinema", 6);
    test8 = new ReservationSuccessMessage("Mark", 5, "MM Cinema", 6);

  }

  @Test
  public void returnMessage() {
    String expected = "I've reserved 3 seats for you at the NEU Cinema in row, 7, John.";
    TestCase.assertEquals(expected, test.returnMessage());
  }

  @Test
  public void testToString() {
    String expected = "ReservationSuccessMessage{name='John', seats=3, theaterName='NEU Cinema', row=7}";
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
    // Different name
    TestCase.assertFalse(test.equals(test4));
    // Different seats
    TestCase.assertFalse(test.equals(test5));
    // Different theater
    TestCase.assertFalse(test.equals(test6));
    // Different row
    TestCase.assertFalse(test.equals(test7));
    // Different all
    TestCase.assertFalse(test.equals(test8));
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