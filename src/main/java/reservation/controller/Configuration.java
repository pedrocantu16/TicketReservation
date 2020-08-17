package reservation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import reservation.controller.CommandParser.Options.DoneOption;
import reservation.controller.CommandParser.Options.IOption;
import reservation.controller.CommandParser.Options.ReserveOption;
import reservation.controller.CommandParser.Options.ShowOption;
import reservation.model.Row;

/**
 * Class responsible for the Rows configuration for a Theater.
 */
public class Configuration {
  /**
   * Singleton instance of Configuration object.
   */
  private static Configuration instance;
  /**
   * Constant value for number of rows in a Theater.
   */
  private static final Integer ROWS_NUMBER = 15;

  /**
   * Constant value for number of seats in a Row.
   * Maximum seats to reserve from a user.
   */
  private static final Integer SEATS_NUMBER = 10;

  /**
   * Constant value for minimum seats to reserve.
   */
  private static final Integer MIN_SEATS = 1;

  /**
   * List of Rows that are wheelchair accessible.
   */
  private static final List<Integer> ACCESSIBLE_ROWS = new ArrayList<>(Arrays.asList(1, 5));

  /**
   * Constructor for Configuration class.
   */
  private Configuration() {
  }

  /**
   * Returns the Configuration object
   * @return the Configuration object
   */
  public static synchronized Configuration getInstance() {
    if (instance == null) {
      instance = new Configuration();
    }
    return instance;
  }

  /**
   * Static method to get a list of rows for a Theater.
   * @return Map of key: Integer, value: Row, with default configuration.
   */
  public Map<Integer, Row> getRows() {
    Map<Integer, Row> rows = new LinkedHashMap<>();
    Predicate<Integer> accessibleCondition = ACCESSIBLE_ROWS::contains; // row is in accessibleRows?
    IntStream.rangeClosed(1, ROWS_NUMBER).forEach(
        x -> rows.put(x,Row.buildRow(SEATS_NUMBER, accessibleCondition.test(x), x)));
    return rows;
  }

  /**
   * Static method to get a list of rows for a Theater.
   * @return List of Row with default configuration.
   */
  public List<Integer> getAccessibleRows() {
    return ACCESSIBLE_ROWS;
  }

  /**
   * Method to get the number of seats per row.
   * @return Integer representing number of seats.
   */
  public Integer getNumberSeats() {
    return SEATS_NUMBER;
  }

  /**
   * Method to get the minimum number of seats to reserve.
   * @return Integer representing number of seats.
   */
  public Integer getMinSeats() {
    return MIN_SEATS;
  }

  /**
   * Get the options that can be validated by the Command Parser.
   * @return List of options.
   */
  public List<IOption> getConfigOptions(){
    //Instantiate options that can be processed by the app
    IOption reserve = ReserveOption.getInstance();
    IOption show = ShowOption.getInstance();
    IOption done = DoneOption.getInstance();

    // Create a list of options that will be passed to the CML Parser
    ArrayList<IOption> options = new ArrayList<>(Arrays.asList(reserve, show, done));
    return options;
  }
  /**
   * Get String representation.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "Configuration{}";
  }
}
