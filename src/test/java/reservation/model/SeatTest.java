package reservation.model;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {
  Seat test;
  Seat test2;
  Seat test3;
  Seat test4;
  Seat test5;
  Seat test6;

  @Before
  public void setUp() throws Exception {
    test = new Seat("A");
    test2 = new Seat("A");
    test3 = new Seat("A");
    test4 = new Seat("B");
    test5 = new Seat("A");
    test5.setReservedFor("John");
    test6 = new Seat("B");
    test6.setReservedFor("John");
  }

  @Test
  public void getReservedFor() {
    TestCase.assertEquals("John", test5.getReservedFor());
  }

  @Test
  public void getName() {
    TestCase.assertEquals("A", test5.getName());
  }

  @Test
  public void setReservedFor() {
    test.setReservedFor("John");
    TestCase.assertEquals("John", test.getReservedFor());
  }

  @Test
  public void isAvailable() {
    TestCase.assertTrue(test.isAvailable());
    TestCase.assertFalse(test5.isAvailable());
  }

  @Test
  public void testToString() {
    String expectedAvailable = "_";
    String expectedReserved = "X";
    TestCase.assertEquals(expectedAvailable, test.toString());
    TestCase.assertEquals(expectedReserved, test5.toString());
  }

  @Test
  public void toStringAccessible() {
    String expectedAvailable = "=";
    String expectedReserved = "X";
    TestCase.assertEquals(expectedAvailable, test.toStringAccessible());
    TestCase.assertEquals(expectedReserved, test5.toStringAccessible());
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
    // Different reserved for
    TestCase.assertFalse(test.equals(test5));
    // Different all
    TestCase.assertFalse(test.equals(test6));
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