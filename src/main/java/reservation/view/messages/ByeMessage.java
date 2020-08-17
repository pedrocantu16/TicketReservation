package reservation.view.messages;

/**
 * Class represents the message to close the program.
 */
public class ByeMessage implements IMessage {
  /**
   * String representation of the message
   */
  private String message;
  /**
   * Singleton instance of ByeMessage object.
   */
  private static ByeMessage instance;

  /**
   * Private Constructor for ByeMessage class. Singleton
   * prevents instantiation outside class.
   */
  private ByeMessage() {
    this.message = "Have a nice day!";
  }

  /**
   * Returns the ByeMessage object
   * @return the ByeMessage object
   */
  public static synchronized ByeMessage getInstance() {
    if (instance == null) {
      instance = new ByeMessage();
    }
    return instance;
  }
  /**
   * Get the string representation of the message.
   * @return A String object.
   */
  @Override
  public String returnMessage() {
    return this.message;
  }
  /**
   * String representation of Object.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "ByeMessage{" +
        "message='" + this.message + '\'' +
        '}';
  }
}
