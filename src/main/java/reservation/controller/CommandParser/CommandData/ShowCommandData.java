package reservation.controller.CommandParser.CommandData;

import reservation.controller.ReservationsService.Processor;

/**
 * Represents a ICommandData object to display seats in Theater.
 */
public class ShowCommandData implements ICommandData{
  /**
   * Singleton instance of ShowCommandData.
   */
  private static ShowCommandData instance;

  /**
   * Private Constructor for ShowCommandData class. Singleton
   * prevents instantiation outside class.
   */
  private ShowCommandData() {
  }

  /**
   * Returns the ShowCommandData object
   * @return the ShowCommandData object
   */
  public static synchronized ShowCommandData getInstance() {
    if (instance == null) {
      instance = new ShowCommandData();
    }
    return instance;
  }

  /**
   * Method to execute the CommandData object.
   * @param processor A Processor for Command Data objects
   */
  @Override
  public int executeCommand(Processor processor) {
    return processor.processDataObject(this);
  }
}
