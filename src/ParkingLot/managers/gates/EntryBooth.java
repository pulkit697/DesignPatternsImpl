package src.ParkingLot.managers.gates;

import src.ParkingLot.managers.parkingManagers.ParkingManager;
import src.ParkingLot.managers.parkingManagers.ParkingManagerFactory;
import src.ParkingLot.models.ParkingSlot;
import src.ParkingLot.models.Ticket;
import src.ParkingLot.models.Vehicle;

public class EntryBooth {

    private final ParkingManagerFactory parkingManagerFactory;

    public EntryBooth() {
        parkingManagerFactory = ParkingManagerFactory.getInstance();
    }

    public Ticket enter(Vehicle vehicle) {
        ParkingManager parkingManager = parkingManagerFactory.getParkingManager(vehicle.getVehicleType());
        if (parkingManager == null) {
            System.out.println("Sorry! We only have 2 & 4 wheeler parking");
            return null;
        }
        ParkingSlot parkingSlot = parkingManager.getVacantSlot();
        if (parkingSlot == null) {
            System.out.println("Sorry! No parking slot available");
            return null;
        }
        return parkingManager.bookSlot(parkingSlot, vehicle);
    }
}
