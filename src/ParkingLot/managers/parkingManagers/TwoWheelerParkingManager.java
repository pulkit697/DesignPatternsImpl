package src.ParkingLot.managers.parkingManagers;

import src.ParkingLot.models.ParkingSlot;
import src.ParkingLot.models.VehicleType;

import java.util.ArrayList;

public class TwoWheelerParkingManager extends ParkingManager {
    private static final int SIZE = 20;

    public TwoWheelerParkingManager() {
        super(SIZE);
    }


    @Override
    public void initializeParkingSlots(int size) {
        parkingSlots = new ArrayList<>();
        for (int i=0; i<SIZE; i++) {
            parkingSlots.add(new ParkingSlot(VehicleType.TWO_WHEELER, "A" + i));
        }
    }
}
