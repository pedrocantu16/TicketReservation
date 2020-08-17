package reservation.view.messages;
/**
 * Class represents the message to notify failed reservation.
 */
public class ReservationFailedMessage implements IMessage{
  /**
   * String representation of the message
   */
  private String message;
  /**
   * Singleton instance of ReservationFailedMessage object.
   */
  private static ReservationFailedMessage instance;

  /**
   * Private Constructor for ReservationFailedMessage class. Singleton
   * prevents instantiation outside class.
   */
  private ReservationFailedMessage() {
    this.message = "Sorry, we don't have that many seats together for you.";
  }

  /**
   * Returns the ReservationFailedMessage object
   * @return the ReservationFailedMessage object
   */
  public static synchronized ReservationFailedMessage getInstance() {
    if (instance == null) {
      instance = new ReservationFailedMessage();
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
    return "ReservationFailedMessage{" +
        "message='" + this.message + '\'' +
        '}';
  }
}
