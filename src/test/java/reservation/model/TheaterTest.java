package reservation.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.Options.ReserveOption;
import reservation.controller.Configuration;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;

public class TheaterTest {
  Theater test;
  Theater test2;
  Theater test3;
  Theater test4;

  @Before
  public void setUp() throws Exception {
    test = new Theater("NEU Cinema", Configuration.getInstance().getRows(), Configuration.getInstance().getAccessibleRows());
    test2 = new Theater("NEU Cinema", Configuration.getInstance().getRows(), Configuration.getInstance().getAccessibleRows());
    test3 = new Theater("NEU Cinema", Configuration.getInstance().getRows(), Configuration.getInstance().getAccessibleRows());
    test4 = new Theater("MM Cinema", Configuration.getInstance().getRows(), Configuration.getInstance().getAccessibleRows());
  }

  @Test (expected = InvalidArgumentException.class)
  public void validateAccessibleRows() {
    Theater test5 = new Theater("MM Cinema", Configuration.getInstance().getRows(), new ArrayList<Integer>());
  }

  @Test
  public void testToString() {
    String expected = "Theater{name='NEU Cinema', rows="
        + "{1== = = = = = = = = = , "
        + "2=_ _ _ _ _ _ _ _ _ _ , "
        + "3=_ _ _ _ _ _ _ _ _ _ , "
        + "4=_ _ _ _ _ _ _ _ _ _ , "
        + "5== = = = = = = = = = , "
        + "6=_ _ _ _ _ _ _ _ _ _ , "
        + "7=_ _ _ _ _ _ _ _ _ _ , "
        + "8=_ _ _ _ _ _ _ _ _ _ , "
        + "9=_ _ _ _ _ _ _ _ _ _ , "
        + "10=_ _ _ _ _ _ _ _ _ _ , "
        + "11=_ _ _ _ _ _ _ _ _ _ , "
        + "12=_ _ _ _ _ _ _ _ _ _ , "
        + "13=_ _ _ _ _ _ _ _ _ _ , "
        + "14=_ _ _ _ _ _ _ _ _ _ , "
        + "15=_ _ _ _ _ _ _ _ _ _ }}";
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