package reservation.controller;

/**
 * Instantiates static nested classes based on the Exception thrown and prints the
 * appropriate error message on the terminal based on the class instantiated.
 */
public class SystemReservationExceptions extends RuntimeException {
  private static String[] flags;
  private static String[] explanations;
  private static String usageHelp;

  /**
   * This constructor prints the error message on command line and exits successfully.
   * @param message Specific error message and usage help message.
   */
  public SystemReservationExceptions(String message) {
    super(message + System.lineSeparator() + usageHelp);
  }

  /**
   * Class to handle errors related arguments passed by the user.
   */
  public static class InvalidArgumentNumber extends SystemReservationExceptions {

    /**
     * This constructor passes the error message to its super class.
     * @param message Error message.
     */
    public InvalidArgumentNumber(String message) {
      super(message);
    }
  }

  /**
   * Class to handle errors related arguments passed by the user.
   */
  public static class MissingArgumentException extends SystemReservationExceptions {

    /**
     * This constructor passes the error message to its super class.
     * @param message Error message.
     */
    public MissingArgumentException(String message) {
      super(message);
    }
  }

  /**
   * Class to handle errors related arguments passed by the user.
   */
  public static class InvalidArgumentException extends SystemReservationExceptions {

    /**
     * This constructor passes the error message to its super class.
     * @param message Error message.
     */
    public InvalidArgumentException(String message) {
      super(message);
    }
  }

  // Used for Usage help generation
  static {
    flags = new String[] {
        "reserve <number>",
        "show",
        "done"
    };

    explanations = new String[] {
        " : To reserve the specified number of seats." + System.lineSeparator(),
        " : To display the current available seating in the theater." + System.lineSeparator(),
        " : To shut down the system." + System.lineSeparator()
    };
  }

  // Used to represent usage help report.
  static {
    usageHelp = System.lineSeparator()+"Usage:"+System.lineSeparator();
    for (int i = 0; i < flags.length; i++) {
      usageHelp += (flags[i] + explanations[i]);
    }
  }

}
