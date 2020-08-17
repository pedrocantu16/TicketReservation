package reservation.model;

import java.util.Objects;

/**
 * Class that represents a reservation object.
 */
public class Reservation {

  /**
   * Number of seats requested to reserve.
   */
  private Integer seats;

  /**
   * Row reserved if reservation succeeded.
   */
  private Integer row;

  /**
   * Name of user that made reservation.
   */
  private String name;

  /**
   * Constructor for Reservation object.
   * @param seats Number of seats to reserve.
   * @param row Row where the reservation happened.
   * @param name User's name.
   */
  public Reservation(Integer seats, Integer row, String name) {
    this.seats = seats;
    this.row = row;
    this.name = name;
  }

  /**
   * Get status of reservation.
   * @return true if succeeded , false otherwise.
   */
  public Boolean getSuccess() {
    return this.row > 0;
  }

  /**
   * Get number of seats reserved.
   * @return number of seats reserved.
   */
  public Integer getSeats() {
    return this.seats;
  }

  /**
   * Get row reserved.
   * @return row where seats were reserved.
   */
  public Integer getRow() {
    return this.row;
  }

  /**
   * Get name.
   * @return name of user.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get string representation.
   * @return String representation of seat.
   */
  @Override
  public String toString() {
    return "Reservation{" +
        "seats=" + this.seats +
        ", row=" + this.row +
        ", name='" + this.name + '\'' +
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
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Reservation that = (Reservation) o;
    return this.getSeats().equals(that.getSeats()) &&
        this.getRow().equals(that.getRow()) &&
        this.getName().equals(that.getName());
  }

  /**
   * Get hash code.
   * @return int value representing hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getSeats(), this.getRow(), this.getName());
  }
}
