package reservation.controller;

import reservation.model.Theater;

/**
 * Entry point to the Reservation System.
 */
public class ReservationsSystem {
  /**
   * Entry point to the program.
   * @param args Arguments from command line.
   */
  public static void main(String[] args) {
    Theater theater = new Theater(
        "NEU Cinema", Configuration.getInstance().getRows(),
        Configuration.getInstance().getAccessibleRows());
    ReservationsService service = new ReservationsService();
    service.runService(theater);
  }
}
