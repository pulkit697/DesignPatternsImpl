package src.ParkingLot.managers.gates;

import src.ParkingLot.managers.parkingManagers.ParkingManager;
import src.ParkingLot.managers.parkingManagers.ParkingManagerFactory;
import src.ParkingLot.models.VehicleType;

public class Gate {
    private final ParkingManagerFactory parkingManagerFactory;

    public Gate() {
        parkingManagerFactory = ParkingManagerFactory.getInstance();
    }

    protected ParkingManager getParkingManager(VehicleType vehicleType) {
        return parkingManagerFactory.getParkingManager(vehicleType);
    }
}
