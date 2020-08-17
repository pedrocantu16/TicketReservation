package reservation.model;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RowTest {
  Row test;
  Row test2;
  Row test3;
  Row test4;
  Row test5;
  Row test6;
  Row test7;

  @Before
  public void setUp() throws Exception {
    test = Row.buildRow(10,false, 1);
    test2 = Row.buildRow(10,false, 1);
    test3 = Row.buildRow(10,false, 1);
    test4 = Row.buildRow(9,false, 1);
    test5 = Row.buildRow(10,true, 1);
    test6 = Row.buildRow(10,false, 2);
    test7 = Row.buildRow(9,true, 2);
  }

  @Test
  public void buildRow() {
    TestCase.assertEquals(test, Row.buildRow(10,false,1));
  }

  @Test
  public void getRowNumber() {
    TestCase.assertEquals(test, Row.buildRow(10,false,1));
  }

  @Test
  public void isAccessible() {
    TestCase.assertTrue(test7.isAccessible());
  }

  @Test
  public void getNumberSeats() {
    TestCase.assertEquals(Integer.valueOf(9), test7.getNumberSeats());
  }

  @Test
  public void getAvailableSeats() {
    TestCase.assertEquals(Integer.valueOf(9), test7.getAvailableSeats());
  }

  @Test
  public void reserve() {
    test.reserve(2, "John");
    TestCase.assertFalse(test.get(1).isAvailable());
  }

  @Test
  public void testToString() {
    String expected = "_ _ _ _ _ _ _ _ _ _ ";
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
    // Different numberOfSeats
    TestCase.assertFalse(test.equals(test4));
    // Different accessible
    TestCase.assertFalse(test.equals(test5));
    // Different rowNumber
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