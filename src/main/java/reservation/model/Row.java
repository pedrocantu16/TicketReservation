package reservation.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * A row is an ArrayList of Seats. Extends ArrayList.
 */
public class Row extends ArrayList<Seat> {

  /**
   * Row number with 1 closest to screen in a Theater.
   */
  private Integer rowNumber;

  /**
   * Indicating whether it is wheelchair accessible.
   */
  private Boolean accessible;

  /**
   * Number of seats in the Row.
   */
  private Integer numberSeats;

  /**
   * Integer representing the index of the next available seat in the row.
   */
  private Integer nextAvailableSeat;

  /**
   * Constructor for a Row.
   * @param numberSeats Number for the row.
   * @param accessible Boolean whether it has wheelchair access.
   */
  private Row(Integer numberSeats, Boolean accessible) {
    this.numberSeats = numberSeats;
    this.accessible = accessible;
    this.createSeats(numberSeats);
  }

  /**
   * Factory method to build a new Row.
   * @param numberSeats Number of seats in the row.
   * @param accessible Whether it has wheelchair access.
   * @param rowNumber Row position from the screen.
   * @return A Row object.
   */
  public static Row buildRow(Integer numberSeats, Boolean accessible, Integer rowNumber) {
    Row newRow = new Row(numberSeats, accessible);
    newRow.rowNumber = rowNumber;
    newRow.nextAvailableSeat = 0;
    return newRow;
  }

  /**
   * Helper method to initialize the Seats.
   * @param number Number of seats in the row
   */
  private void createSeats(Integer number) {
    int end = 'A' + number;
    IntStream.range('A', end).mapToObj(x -> (char) x).forEach(x -> this.add(new Seat(String.valueOf(x))));
  }

  /**
   * Get access to the row number field.
   * @return Integer representing row number.
   */
  public Integer getRowNumber() {
    return this.rowNumber;
  }

  /**
   * Get access to the boolean accessible field.
   * @return Boolean whether the row is wheelchair accessible.
   */
  public Boolean isAccessible() {
    return this.accessible;
  }

  /**
   * Get access to the number of seats field.
   * @return Integer representing number of seats in the Row.
   */
  public Integer getNumberSeats() {
    return this.numberSeats;
  }

  /**
   * Method to get the number of available Seats in the row.
   * @return Number of seats available in the row.
   */
  public Integer getAvailableSeats() {
    long count = this.stream().filter(Seat::isAvailable).count();
    return (int) count;
  }

  /**
   * Method to reserve seats in this row.
   * @param numberSeats Number of seats to reserve in the row
   * @param name Name of the user making the reservation
   */
  public void reserve(Integer numberSeats, String name) {
    for(int i = 0; i < numberSeats; i++) {
      this.get(this.nextAvailableSeat++).setReservedFor(name);
    }
  }

  /**
   * Get string representation.
   * @return String representation of seat.
   */
  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    this.forEach(x -> {if(this.accessible) { buffer.append(x.toStringAccessible()).append(" ");} else {
      buffer.append(x.toString()).append(" ");}});
    return buffer.toString();
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
    Row row = (Row) o;
    return this.getRowNumber().equals(row.getRowNumber()) &&
        this.isAccessible().equals(row.isAccessible()) &&
        this.getNumberSeats().equals(row.getNumberSeats());
  }

  /**
   * Get hash code.
   * @return int value representing hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getRowNumber(), this.isAccessible(),
        this.getNumberSeats());
  }
}
