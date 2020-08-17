package reservation.controller.CommandParser.Options;

import java.util.List;
import reservation.controller.CommandParser.CommandData.DoneCommandData;
import reservation.controller.CommandParser.CommandData.ICommandData;

/**
 * Represents an Option that can be passed to the program to close the program.
 */
public class DoneOption implements IOption {

  /**
   * Singleton instance of DoneOption object.
   */
  private static DoneOption instance;
  /**
   * String representing expected argument.
   */
  private static final String ARGUMENT = "done";

  /**
   * Private Constructor for DoneOption class. Singleton
   * prevents instantiation outside class.
   */
  private DoneOption() {
  }

  /**
   * Returns the DoneOption object
   * @return the DoneOption object
   */
  public static synchronized DoneOption getInstance() {
    if (instance == null) {
      instance = new DoneOption();
    }
    return instance;
  }

  /**
   * Method to validate the arguments of an option.
   * @param args List of arguments passed to the program by the user.
   * @return ICommandData object with all the fields passed by the user.
   */
  @Override
  public ICommandData validateArgs(List<String> args) {
    if(args.contains(ARGUMENT)) {
      args.remove(ARGUMENT);
      return DoneCommandData.getInstance();
    }
    return null;
  }
  /**
   * Get String representation.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "DoneOption{}";
  }
}
