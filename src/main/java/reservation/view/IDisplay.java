package reservation.view;

import reservation.model.Theater;
import reservation.view.messages.IMessage;

/**
 * Interface IDisplay contains behavior to print to the terminal.
 */
public interface IDisplay {

  /**
   * Method to print IMessage objects to the terminal.
   * @param message A message object.
   */
  void display(IMessage message);

  /**
   * Method to print a String object to the terminal.
   * @param message A string object.
   */
  void display(String message);

  /**
   * Method to display the seats in the theater.
   * @param theater A theater object.
   */
  void displayTheater(Theater theater);

}
