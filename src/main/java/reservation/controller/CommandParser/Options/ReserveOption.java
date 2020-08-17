package reservation.controller.CommandParser.Options;

import java.util.List;
import java.util.regex.Pattern;
import reservation.controller.CommandParser.CommandData.ICommandData;
import reservation.controller.CommandParser.CommandData.ReserveCommandData;
import reservation.controller.Configuration;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;
import reservation.controller.SystemReservationExceptions.MissingArgumentException;

/**
 * Represents an Option that can be passed to the program to reserve seats in the Theater.
 */
public class ReserveOption implements IOption {
  /**
   * Singleton instance of AddToDoOption object.
   */
  private static ReserveOption instance;
  /**
   * String representing expected argument.
   */
  private static final String ARGUMENT = "reserve";

  /**
   * Private Constructor for ReserveOption class. Singleton
   * prevents instantiation outside class.
   */
  private ReserveOption() {
  }

  /**
   * Returns the ReserveOption object
   * @return the ReserveOption object
   */
  public static synchronized ReserveOption getInstance() {
    if (instance == null) {
      instance = new ReserveOption();
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
      ReserveCommandData command = new ReserveCommandData();
      this.isValidNumber(command, args);
      args.remove(ARGUMENT); // remove validated argument.
      return command;
    }
    return null;
  }

  /**
   * Helper method to validate if the number of seats to reserve was passed and is valid.
   * @param command A ICommand Data object.
   * @param args List of arguments.
   */
  private void isValidNumber(ReserveCommandData command, List<String> args) {
    try {
      String numberOfSeats = args.get(args.indexOf(ARGUMENT)+1); // number next to "reserve"
      if(Pattern.compile("\\d+").matcher(numberOfSeats).matches()) {
        Integer seats = Integer.parseInt(numberOfSeats);
        this.validateNumSeats(seats); // validate min and max number of seats to reserve
        command.setNumberOfSeats(seats);
        args.remove(numberOfSeats); // clean validated argument.
      } else {
        throw new InvalidArgumentException("Invalid format for number of seats to reserve.");
      }
    } catch(IndexOutOfBoundsException ind) {
      throw new MissingArgumentException("No number of seats passed with 'reserve'.");
    }
  }

  /**
   * Helper to validate the number of seats requested by the user.
   * @param seats Number of seats requested by the user.
   */
  private void validateNumSeats(Integer seats) {
    if(seats > Configuration.getInstance().getNumberSeats()) {
      throw new InvalidArgumentException("Sorry, we don't have that many seats together for you.");
    }
    if(seats < Configuration.getInstance().getMinSeats()) {
      throw new InvalidArgumentException("Invalid number of seats received.");
    }
  }

  /**
   * Get String representation.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "ReserveOption{}";
  }
}
