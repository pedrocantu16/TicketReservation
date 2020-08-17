package reservation.view;

import java.util.Map;
import reservation.model.Row;
import reservation.model.Theater;
import reservation.view.messages.IMessage;

public class DisplayTheater implements IDisplay{

  /**
   * Constructor for DisplayTheater.
   */
  public DisplayTheater() {
  }

  /**
   * Method to print IMessage objects to the terminal.
   * @param message A message object.
   */
  @Override
  public void display(IMessage message) {
    System.out.print(message.returnMessage()+System.lineSeparator());

  }

  /**
   * Method to print a String object to the terminal.
   * @param message A string object.
   */
  @Override
  public void display(String message) {
    System.out.print(message+System.lineSeparator());
  }

  /**
   * Method to display the seats in the theater.
   * @param theater A theater object.
   */
  @Override
  public void displayTheater(Theater theater) {
    Map<Integer, Row> rows = theater.getRows();
    for(Row row : rows.values()){
      System.out.printf("%-3s",row.getRowNumber());
      System.out.print(row);
      System.out.print(System.lineSeparator());
    }
  }
}
