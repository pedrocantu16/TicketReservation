package reservation.controller.CommandParser.Options;

import java.util.List;
import reservation.controller.CommandParser.CommandData.ICommandData;
import reservation.controller.CommandParser.CommandData.ShowCommandData;

/**
 * Represents an Option that can be passed to the program to display seats in the Theater.
 */
public class ShowOption implements IOption {
  /**
   * Singleton instance of ShowOption object.
   */
  private static ShowOption instance;
  /**
   * String representing expected argument.
   */
  private static final String ARGUMENT = "show";

  /**
   * Private Constructor for ShowOption class. Singleton
   * prevents instantiation outside class.
   */
  private ShowOption() {
  }

  /**
   * Returns the ShowOption object
   * @return the ShowOption object
   */
  public static synchronized ShowOption getInstance() {
    if (instance == null) {
      instance = new ShowOption();
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
      return ShowCommandData.getInstance();
    }
    return null;
  }

  /**
   * Get String representation.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "ShowOption{}";
  }
}
