package reservation.controller.CommandParser.Options;

import java.util.List;
import reservation.controller.CommandParser.CommandData.ICommandData;

/**
 * Interface represents an Option that user can pass to the program.
 */
public interface IOption {

  /**
   * Method to validate the arguments of an option.
   * @param args List of arguments passed to the program by the user.
   * @return ICommandData object with all the fields passed by the user.
   */
  ICommandData validateArgs(List<String> args);

}
