package reservation.controller;

import java.util.Scanner;
import reservation.controller.CommandParser.CommandData.DoneCommandData;
import reservation.controller.CommandParser.CommandData.ICommandData;
import reservation.controller.CommandParser.CommandData.ReserveCommandData;
import reservation.controller.CommandParser.CommandData.ShowCommandData;
import reservation.controller.CommandParser.CommandParser;
import reservation.controller.SystemReservationExceptions.InvalidArgumentException;
import reservation.model.Reservation;
import reservation.model.Theater;
import reservation.view.DisplayTheater;
import reservation.view.IDisplay;
import reservation.view.messages.AskAccessibleMessage;
import reservation.view.messages.AskNameMessage;
import reservation.view.messages.ByeMessage;
import reservation.view.messages.PromptUserMessage;
import reservation.view.messages.ReservationFailedMessage;
import reservation.view.messages.ReservationSuccessMessage;

/**
 * This class controls the execution of the reservation service.
 */
public class ReservationsService {

  /**
   * Control of the program execution.
   */
  private Boolean running = true;
  /**
   * Instance of DisplayTheater class.
   */
  private IDisplay terminalDisplay = new DisplayTheater();

  /**
   * Instance of Command Parser.
   */
  private CommandParser commandParser = CommandParser.getInstance();

  /**
   * Instance of Theater.
   */
  private static Theater thisTheater;

  /**
   * Constructor for ReservationService class.
   */
  public ReservationsService() {
  }

  /**
   * Method that implements the actual reservation service.
   * @param theater A theater to make reservations.
   */
  public void runService(Theater theater) {
    ReservationsService.Processor processor = new ReservationsService.Processor();
    Scanner scanner = new Scanner(System.in);
    String readIn;
    thisTheater = theater;
    while(running) {
      try {
        terminalDisplay.display(PromptUserMessage.getInstance());
        readIn = scanner.nextLine();
        ICommandData command = commandParser.parse(readIn);
        command.executeCommand(processor);
      } catch (SystemReservationExceptions exc) {
        terminalDisplay.display(exc.getMessage());
      }
    }
    terminalDisplay.display(ByeMessage.getInstance());
  }

  /**
   * Inner class to ReservationsServices to execute commands.
   */
  public class Processor {

    /**
     * Constructor for Processor.
     */
    public Processor() {
    }

    /**
     * Method to process a reservation.
     * @param reserveCommand ReserveCommandData to process a reservation.
     * @return int value representing exit status.
     */
    public int processDataObject(ReserveCommandData reserveCommand) {
      Scanner scanner2 = new Scanner(System.in);
      // Ask whether wheelchair access is needed
      terminalDisplay.display(AskAccessibleMessage.getInstance());
      String access = scanner2.nextLine(); // wait for response
      boolean response = processBooleanResponse(access); // process response from user
      // Ask name of the user
      terminalDisplay.display(AskNameMessage.getInstance());
      String name = scanner2.nextLine();
      // Process reservation
      Reservation reservation = thisTheater.reserveSeats(reserveCommand.getNumberOfSeats(),
          response, name);
      // Validate result from reservation and display messages accordingly
      if(reservation.getSuccess()) {
        terminalDisplay.display(new ReservationSuccessMessage(name, reservation.getSeats(),
            thisTheater.getName(), reservation.getRow()));
      } else {
        terminalDisplay.display(ReservationFailedMessage.getInstance());
      }
      return 0;
    }

    /**
     * Method to call display of Theater.
     * @param command A ShowCommandData object, if specified by the user.
     * @return int value representing exit status.
     */
    public int processDataObject(ShowCommandData command) {
      terminalDisplay.displayTheater(thisTheater);
      return 0;
    }

    /**
     * Method to terminate the program.
     * @param command DoneCommandData object whe user input "done".
     * @return int value representing exit status.
     */
    public int processDataObject(DoneCommandData command) {
      running = false;
      return 0;
    }

    /**
     * Helper to validate response from the user when asked about wheelchair access required.
     * @param response Response from the user.
     * @return boolean response.
     */
    private boolean processBooleanResponse(String response) {
      String lowerResponse = response.toLowerCase();
      if(lowerResponse.equals("yes")) {
        return true;
      } else if(lowerResponse.equals("no")) {
        return false;
      } else {
        throw new InvalidArgumentException("Invalid response.");
      }
    }

    /**
     * Method to set a theater for testing purposes, so ShowCommandData can display a theater.
     * @param theater A theater.
     */
    public void setTheater(Theater theater) {
      thisTheater = theater;
    }

  }

}
