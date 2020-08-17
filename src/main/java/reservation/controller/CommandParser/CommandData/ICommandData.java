package reservation.controller.CommandParser.CommandData;

import reservation.controller.ReservationsService;
import reservation.controller.ReservationsService.Processor;

/**
 * Command Data object gathers the arguments passed to the program.
 * Represents a Command to Execute with the arguments specified by the user.
 */
public interface ICommandData {

  /**
   * Method to execute the CommandData object.
   * @param processor A Processor for Command Data objects.
   * @return integer representing exit status.
   */
  int executeCommand(ReservationsService.Processor processor);

}
