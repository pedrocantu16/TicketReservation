package reservation.controller.CommandParser.CommandData;

import static org.junit.Assert.*;

import javax.annotation.processing.Processor;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.ReservationsService;

public class DoneCommandDataTest {
  ReservationsService.Processor processor = new ReservationsService().new Processor();

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(DoneCommandData.getInstance(), DoneCommandData.getInstance());
  }

  @Test
  public void executeCommand() {
    TestCase.assertEquals(0, DoneCommandData.getInstance().executeCommand(processor));
  }
}