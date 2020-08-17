package reservation.controller.CommandParser.CommandData;

import static org.junit.Assert.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import reservation.controller.Configuration;
import reservation.controller.ReservationsService;
import reservation.model.Theater;

public class ShowCommandDataTest {
  ReservationsService.Processor processor = new ReservationsService().new Processor();
  Theater testTheater;

  @Before
  public void setUp() throws Exception {
    testTheater = new Theater("Test Theater", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    processor.setTheater(testTheater);
  }

  @Test
  public void getInstance() {
    TestCase.assertEquals(ShowCommandData.getInstance(), ShowCommandData.getInstance());
  }

  @Test
  public void executeCommand() {

    TestCase.assertEquals(0, ShowCommandData.getInstance().executeCommand(processor));
  }
}