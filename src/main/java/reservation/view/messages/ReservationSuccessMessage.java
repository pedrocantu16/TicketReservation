package reservation.view.messages;

import java.util.Objects;

/**
 * Class represents the message to notify the user if reservation succeeded.
 */
public class ReservationSuccessMessage implements IMessage{

  /**
   * Name of the user who made reservation.
   */
  private String name;

  /**
   * Number of seats reserved.
   */
  private Integer seats;

  /**
   * Name of the Theater.
   */
  private String theaterName;

  /**
   * Row where the seats were reserved.
   */
  private Integer row;

  /**
   * Constructor for Success Message.
   * @param name Name of the user.
   * @param seats Number of seats reserved.
   * @param theater Theater name.
   * @param row row reserved.
   */
  public ReservationSuccessMessage(String name, Integer seats, String theater, Integer row) {
    this.name = name;
    this.seats = seats;
    this.theaterName = theater;
    this.row = row;
  }

  /**
   * Get the string representation of the message.
   * @return A String object.
   */
  @Override
  public String returnMessage() {
    return "I've reserved " + this.seats +
        " seats for you at the " + this.theaterName + " in row, " +
        this.row + ", " + this.name + ".";
  }
  /**
   * String representation of Object.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "ReservationSuccessMessage{" +
        "name='" + this.name + '\'' +
        ", seats=" + this.seats +
        ", theaterName='" + this.theaterName + '\'' +
        ", row=" + this.row +
        '}';
  }

  /**
   * Compare objects.
   * @param o Another object.
   * @return boolean whether objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ReservationSuccessMessage)) {
      return false;
    }
    ReservationSuccessMessage that = (ReservationSuccessMessage) o;
    return this.name.equals(that.name) &&
        this.seats.equals(that.seats) &&
        this.theaterName.equals(that.theaterName) &&
        this.row.equals(that.row);
  }

  /**
   * Get hash code.
   * @return int value representing hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.seats, this.theaterName, this.row);
  }
}
