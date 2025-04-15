package src.ParkingLot.managers.gates;

import src.ParkingLot.managers.parkingManagers.FourWheelerParkingManager;
import src.ParkingLot.managers.parkingManagers.ParkingManager;
import src.ParkingLot.managers.parkingManagers.TwoWheelerParkingManager;
import src.ParkingLot.models.VehicleType;

public class Gate {
    private final ParkingManager twoWheelerParkingManager;
    private final ParkingManager fourWheelerParkingManager;

    public Gate() {
        twoWheelerParkingManager = new TwoWheelerParkingManager();
        fourWheelerParkingManager = new FourWheelerParkingManager();
    }

    protected ParkingManager getParkingManager(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER:
                return twoWheelerParkingManager;
            case FOUR_WHEELER:
                return fourWheelerParkingManager;
        }
        return null;
    }
}
