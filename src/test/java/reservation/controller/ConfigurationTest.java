package reservation.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.CommandParser.Options.DoneOption;
import reservation.controller.CommandParser.Options.IOption;
import reservation.model.Row;

public class ConfigurationTest {
  Configuration testConfig = Configuration.getInstance();
  List<Integer> accessibleRows = new ArrayList<>(Arrays.asList(1, 5));
  Map<Integer, Row> expectedRows = testConfig.getRows();
  List<IOption> expectedOptions = testConfig.getConfigOptions();
  String expectedString = "Configuration{}";

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(testConfig, Configuration.getInstance());
  }

  @Test
  public void getRows() {
    TestCase.assertEquals(expectedRows, testConfig.getRows());
  }

  @Test
  public void getAccessibleRows() {
    TestCase.assertEquals(accessibleRows, testConfig.getAccessibleRows());
  }

  @Test
  public void getNumberSeats() {
    TestCase.assertEquals(Integer.valueOf(10), testConfig.getNumberSeats());
  }

  @Test
  public void getMinSeats() {
    TestCase.assertEquals(Integer.valueOf(1), testConfig.getMinSeats());
  }

  @Test
  public void getConfigOptions() {
    TestCase.assertEquals(expectedOptions, testConfig.getConfigOptions());
  }

    @Test
    public void toStringTest() {
      TestCase.assertEquals(expectedString, testConfig.toString());
    }
}