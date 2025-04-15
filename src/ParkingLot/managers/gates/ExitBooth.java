package src.ParkingLot.managers.gates;

import src.ParkingLot.managers.parkingManagers.ParkingManager;
import src.ParkingLot.managers.parkingManagers.ParkingManagerFactory;
import src.ParkingLot.models.Ticket;
import src.ParkingLot.models.VehicleType;

import java.time.Instant;
import java.util.Date;

public class ExitBooth {

    private final ParkingManagerFactory parkingManagerFactory;

    public ExitBooth() {
        parkingManagerFactory = ParkingManagerFactory.getInstance();
    }

    public int exit(Ticket ticket) {
        VehicleType vehicleType = ticket.getVehicleType();
        ParkingManager parkingManager = parkingManagerFactory.getParkingManager(vehicleType);
        if (parkingManager == null) {
            throw new RuntimeException("Unexpected vehicle type at exit gate");
        }
        parkingManager.unBookSlot(ticket);
        System.out.println("Exit time: " + Date.from(Instant.now()));
        return parkingManager.getBill(ticket);
    }
}
