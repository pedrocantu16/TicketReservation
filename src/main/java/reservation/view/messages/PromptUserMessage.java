package reservation.view.messages;

/**
 * Class represents the message to prompt the user for arguments.
 */
public class PromptUserMessage implements IMessage {
  /**
   * String representation of the message
   */
  private String message;
  /**
   * Singleton instance of PromptUserMessage object.
   */
  private static PromptUserMessage instance;

  /**
   * Private Constructor for PromptUserMessage class. Singleton
   * prevents instantiation outside class.
   */
  private PromptUserMessage() {
    this.message = "What would you like to do?";
  }

  /**
   * Returns the PromptUserMessage object
   * @return the PromptUserMessage object
   */
  public static synchronized PromptUserMessage getInstance() {
    if (instance == null) {
      instance = new PromptUserMessage();
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
    return "PromptUserMessage{" +
        "message='" + this.message + '\'' +
        '}';
  }
}
