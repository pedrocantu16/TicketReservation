package reservation.controller.CommandParser.CommandData;

import java.util.Objects;
import reservation.controller.ReservationsService.Processor;

/**
 * Represents a ICommandData  object to execute reservation.
 */
public class ReserveCommandData implements ICommandData{

  /**
   * Number of seats to reserve;
   */
  private Integer numberOfSeats;

  /**
   * Constructor for ReserveCommandData object.
   */
  public ReserveCommandData() {
    this.numberOfSeats = 0;
  }

  /**
   * Get numbers of seat to reserve
   * @return Number of seats to reserve.
   */
  public Integer getNumberOfSeats() {
    return this.numberOfSeats;
  }

  /**
   * Set the number of seats to reserve.
   * @param numberOfSeats Integer representing numbers of seats required by user.
   */
  public void setNumberOfSeats(Integer numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  /**
   * Method to execute the CommandData object.
   * @param processor A Processor for Command Data objects
   */
  @Override
  public int executeCommand(Processor processor) {
    return processor.processDataObject(this);
  }

  /**
   * Get string representation.
   * @return String representation of object.
   */
  @Override
  public String toString() {
    return "ReserveCommandData{" +
        "numberOfSeats=" + numberOfSeats +
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
    ReserveCommandData that = (ReserveCommandData) o;
    return this.getNumberOfSeats().equals(that.getNumberOfSeats());
  }

  /**
   * Get hash code.
   * @return int value representing hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getNumberOfSeats());
  }
}
