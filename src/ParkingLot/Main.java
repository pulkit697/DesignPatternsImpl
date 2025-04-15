package src.ParkingLot;

import src.ParkingLot.managers.EntryBooth;
import src.ParkingLot.managers.ExitBooth;
import src.ParkingLot.models.Ticket;
import src.ParkingLot.models.Vehicle;
import src.ParkingLot.models.VehicleType;

public class Main {
    public static void main(String[] args) {
        EntryBooth entryBooth = new EntryBooth();
        ExitBooth exitBooth = new ExitBooth();

        Vehicle vehicle1 = new Vehicle("KA01AB9999", VehicleType.TWO_WHEELER);
        Ticket ticket = entryBooth.enter(vehicle1);
        if (ticket != null) {
            ticket.display();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int amount = exitBooth.exit(ticket);
            System.out.println("Total Bill: ₹" + amount);
        }
    }
}
