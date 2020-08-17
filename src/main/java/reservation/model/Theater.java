package reservation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;

/**
 * Class represents a Movie Theater.
 */
public class Theater {
  /**
   * Name of the Theater.
   */
  private String name;

  /**
   * A Map of rows.
   */
  private Map<Integer, Row> rows;

  /**
   * List with the row number of rows with wheelchair access.
   */
  private List<Integer> accessibleRows;

  /**
   * The list contains the row numbers in the order to find optimal row.
   * First row is the middle row of the theater. Then one behind, then one in front.
   * Until it reaches the farthest row from the middle row.
   */
  private List<Integer> orderRow;

  /**
   * Constructor for Theater.
   * @param name Name of the Theater.
   * @param rows A map of rows.
   * @param accessibleRows List of row numbers with wheel chair access.
   */
  public Theater(String name, Map<Integer,Row> rows, List<Integer> accessibleRows) {
    this.name = name;
    this.rows = rows;
    this.accessibleRows = accessibleRows;
    this.orderRow = this.optimalOrder();
    this.validateAccessibleRows();
  }

  /**
   * Helper method to make sure a Theater can't be created without accessible rows.
   */
  private void validateAccessibleRows() {
    if(this.accessibleRows.isEmpty()) {
      throw new InvalidArgumentException("Theater can't be created without accessible rows.");
    }
  }

  /**
   * Method to make a reservation of seats in the Theater.
   * @param numberSeats Number of seats to reserve
   * @param accessible Boolean indicating whether user needs wheelchair access.
   * @param name Name of the user.
   * @return Reservation object.
   */
  public Reservation reserveSeats(Integer numberSeats, Boolean accessible, String name) {
    int row = 0;
    if (accessible) {
      row = this.findAccessibleRow(numberSeats); // find accessible row.
    } else {
      row = this.findRegularRow(numberSeats); // find non-accessible row.
      if (row == 0) { // if there are no enough seats in non-accessible rows.
        row = this.findAccessibleRow(numberSeats); // look in the accessible rows.
      }
    }
    if(row > 0) { // If a row was found, reserve the seats.
      this.makeReservation(row, numberSeats, name);
    }
    return new Reservation(numberSeats, row, name); // return a reservation object as a response
  }

  /**
   * Helper to mark the seats as reserved.
   * @param rowNumber Row where to make the reservation
   * @param numberSeats Number of seats to reserve.
   * @param name Name of user making reservation.
   */
  private void makeReservation (Integer rowNumber, Integer numberSeats, String name) {
    Row row = this.rows.get(rowNumber);
    row.reserve(numberSeats, name);
  }

  /**
   * Helper to find the best row with wheel chair access to reserve seats.
   * @param numSeats Number of seats to reserve.
   * @return Row number with wheel chair access that has enough available seats. 0 if not found.
   */
  private int findAccessibleRow(Integer numSeats) {
    int i = this.accessibleRows.size() - 1; // last index of the accessibleRows list
    for(;i >= 0; i--) {
      if(this.rows.get(this.accessibleRows.get(i)).getAvailableSeats() >= numSeats) {
        return this.accessibleRows.get(i); // return the number of the accessible row
      }
   }
    return 0; // there are no enough seats available in the accessible rows.
  }

  /**
   * Helper to find the best row with no wheel chair access to reserve seats.
   * @param numSeats Number of seats to reserve.
   * @return Row number with no wheel chair access that has enough seats to reserve. 0 if not found.
   */
  private int findRegularRow(Integer numSeats) {
    for (Integer key : this.orderRow) { // accessing the rows in the order from orderRow
      Row row = this.rows.get(key);
      if(!row.isAccessible()) { // if row has no wheelchair access
        if(row.getAvailableSeats() >= numSeats){
          return key; // return row number
        }
      }
    }
    return 0; // there are no available rows to reserve this numSeats
  }

  /**
   * Helper method to get the order of traversal to find an optimal row, starting from mid row.
   * @return List with indexes in order to find the optimal row to reserve a seat.
   */
  private List<Integer> optimalOrder() {
    List<Integer> orderedIndex = new ArrayList<>();
    int i = 1;
    int midRow = (this.rows.size()) / 2; // mid row number
    orderedIndex.add(midRow); // the first row to look into when looking for a row to reserve seats
    while(orderedIndex.size() < this.rows.size()) { // While not the same size
      if((midRow + i <= this.rows.size())) { // if (mid-row-index + i) is not out of bound
//      if((midRow - i) >= 1) { // If (mid-row-index - i) is not out of bound
        orderedIndex.add(midRow + i); // add the row number to the orderedIndex list
      }
      if((midRow - i) >= 1) { // If (mid-row-index - i) is not out of bound
//      if((midRow + i <= this.rows.size())) { // if (mid-row-index + i) is not out of bound
        orderedIndex.add(midRow - i); // add the row number to the orderedIndex list
      }
      i++; // furthering away from mid row index
    }
    return orderedIndex;
  }

  /**
   * Get the name of the theater.
   * @return Name of the Theater.
   */
  public String getName() {
    return this.name;
  }


  /**
   * Get the rows of the Theater.
   * @return Map with key: Integer, value: Row, representing the rows in the Theater.
   */
  public Map<Integer, Row> getRows() {
    return this.rows;
  }

  /**
   * Get string representation of object.
   * @return String representation of the Theater object.
   */
  @Override
  public String toString() {
    return "Theater{" +
        "name='" + this.name + '\'' +
        ", rows=" + this.rows +
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
    Theater theater = (Theater) o;
    return this.getName().equals(theater.getName());
  }
  /**
   * Get hash code.
   * @return int value representing hash value.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getName());
  }
}
