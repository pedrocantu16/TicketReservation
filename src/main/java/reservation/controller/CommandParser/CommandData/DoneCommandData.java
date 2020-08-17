package reservation.controller.CommandParser.CommandData;

import reservation.controller.ReservationsService.Processor;

/**
 * Represents a ICommandData object to exit the system.
 */
public class DoneCommandData implements ICommandData{
  /**
   * Singleton instance of DoneCommandData.
   */
  private static DoneCommandData instance;

  /**
   * Private Constructor for DoneCommandData class. Singleton
   * prevents instantiation outside class.
   */
  private DoneCommandData() {
  }

  /**
   * Returns the DoneCommandData object
   * @return the DoneCommandData object
   */
  public static synchronized DoneCommandData getInstance() {
    if (instance == null) {
      instance = new DoneCommandData();
    }
    return instance;
  }

  /**
   * Method to execute the CommandData object.
   * @param processor A Processor for Command Data objects.
   * @return int representing exit status.
   */
  @Override
  public int executeCommand(Processor processor) {
    return processor.processDataObject(this);
  }
}
