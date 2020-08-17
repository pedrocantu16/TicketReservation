package reservation.controller.CommandParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import reservation.controller.CommandParser.CommandData.ICommandData;
import reservation.controller.CommandParser.Options.IOption;
import reservation.controller.Configuration;
import reservation.controller.SystemReservationExceptions.InvalidArgumentNumber;

/**
 * Processes and validates inputs passed by the user.
 * When called method parse, it returns a CommandData object.
 */
public class CommandParser {
  /**
   * Singleton instance of CommandParser object.
   */
  private static CommandParser instance;
  /**
   * Constant value representing the number of options the program can handle from the user
   * every time user isn prompted with "What would you like to do?"
   */
  private static final Integer MAX_OPTIONS = 1;
  /**
   * List of Options to validate.
   */
  private List<IOption> options;

  /**
   * Constructor for CommandParser class.
   * @param options List of Options to validate.
   */
  private CommandParser(List<IOption> options) {
    this.options = options;
  }

  /**
   * Returns the Command Parser object
   * @return the Command Parser object
   */
  public static synchronized CommandParser getInstance() {
    if (instance == null) {
      instance = new CommandParser(Configuration.getInstance().getConfigOptions());
    }
    return instance;
  }

  /**
   * Method to parse and validate arguments provided by user.
   * @param args The arguments provided by the user.
   * @return A ICommandData object.
   */
  public ICommandData parse(String args){
    String[] arrayArgs = args.split("\\s+");
    List<String> argsList = new ArrayList<>(Arrays.asList(arrayArgs)); // Convert array to list of args
    List<ICommandData> commands = new ArrayList<>(); // Creating a list of ICommandData objects
    for(IOption option : this.options) {
      ICommandData command = option.validateArgs(argsList); // Validate the options
      if(command != null){ // If the return value from ValidateArgs is not null add to the list
        commands.add(command);
      }
    }
    this.cleanArgs(argsList); // After processing each valid option, list ArrayArgs size should be 0
    this.countCommands(commands); // Program can accept only one option at a time
    return commands.get(0); // Only one command to process for every prompt to the user
  }

  /**
   * Helper to validate user only passed one option to the program when prompted for action.
   * @param commands List of CommandData objects.
   */
  private void countCommands(List<ICommandData> commands) {
    if ((commands.size() > MAX_OPTIONS)) {
      throw new InvalidArgumentNumber("\nMultiple valid arguments passed.");
    }
  }

  /**
   * Helper method to validate if non-recognized arguments were passed to the command line.
   * @param argsList List of command line arguments.
   */
  private void cleanArgs(List<String> argsList) {
    if (argsList.size() > 0) {
      StringBuilder invalidArgs = new StringBuilder();
      for (String s : argsList) {
        invalidArgs.append(s).append(" ");
      }
      throw new InvalidArgumentNumber("\nInvalid arguments: "
          + invalidArgs + " provided.");
    }
  }

  /**
   * Get String representation.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "CommandParser{" +
        "options=" + this.options +
        '}';
  }
}
