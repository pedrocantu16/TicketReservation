package reservation.view.messages;
/**
 * Class represents the message to ask the user's name.
 */
public class AskNameMessage implements IMessage{
  /**
   * String representation of the message
   */
  private String message;
  /**
   * Singleton instance of AskNameMessage object.
   */
  private static AskNameMessage instance;

  /**
   * Private Constructor for AskNameMessage class. Singleton
   * prevents instantiation outside class.
   */
  private AskNameMessage() {
    this.message = "What's your name?";
  }

  /**
   * Returns the AskNameMessage object
   * @return the AskNameMessage object
   */
  public static synchronized AskNameMessage getInstance() {
    if (instance == null) {
      instance = new AskNameMessage();
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
    return "AskNameMessage{" +
        "message='" + this.message + '\'' +
        '}';
  }
}
