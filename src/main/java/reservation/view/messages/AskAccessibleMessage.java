package reservation.view.messages;

/**
 * Class represents the message to ask whether the user needs wheelchair access.
 */
public class AskAccessibleMessage implements IMessage{
  /**
   * String representation of the message
   */
  private String message;
  /**
   * Singleton instance of AskAccessibleMessage object.
   */
  private static AskAccessibleMessage instance;

  /**
   * Private Constructor for AskAccessibleMessage class. Singleton
   * prevents instantiation outside class.
   */
  private AskAccessibleMessage() {
    this.message = "Do you need wheelchair accessible seats? Please respond: 'yes' / 'no'.";
  }

  /**
   * Returns the AskAccessibleMessage object
   * @return the AskAccessibleMessage object
   */
  public static synchronized AskAccessibleMessage getInstance() {
    if (instance == null) {
      instance = new AskAccessibleMessage();
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
    return "AskAccessibleMessage{" +
        "message='" + this.message + '\'' +
        '}';
  }
}

