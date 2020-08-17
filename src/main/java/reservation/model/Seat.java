package reservation.model;

import java.util.Objects;

/**
 * Class represents a seat object in a Theater.
 */
public class Seat {

  /**
   * String value representing a capital letter from A to Z.
   */
  private String name;

  /**
   * Representing the name of the person for whom it has been reserved, or null if it has not been
   * reserved.
   */
  private String reservedFor;

  /**
   * Constructor for a Seat object.
   * @param name String value representing a capital letter from A to Z.
   */
  public Seat(String name) {
    this.name = name;
    this.reservedFor = null;
  }

  /**
   * Get reservation name for the seat.
   * @return String representing name of the user who reserved.
   */
  public String getReservedFor() {
    return this.reservedFor;
  }

  /**
   * Set the name of the user reserving the seat.
   * @param reservedFor String representing name of the user.
   */
  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }

  /**
   * Method to check if a Seat is reserved.
   * @return true when is not reserved, false when reserved.
   */
  public Boolean isAvailable() {
    return this.reservedFor == null;
  }

  /**
   * Get letter from the Seat.
   * @return String with letter assigned to the Seat.
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
    if(this.isAvailable()) {
      return "_";
    } else {
      return "X";
    }
  }

  /**
   * Get string representation when the seat is in a wheel chair accessible row.
   * @return String representation of seat.
   */
  public String toStringAccessible() {
    if(this.isAvailable()){
      return "=";
    } else {
      return "X";
    }
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
    Seat seat = (Seat) o;
    return this.name.equals(seat.name) &&
        Objects.equals(this.getReservedFor(),seat.getReservedFor());
  }



  /**
   * Get hash code.
   * @return int value representing hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.getReservedFor());
  }
}
