package src.ParkingLot.managers;

import src.ParkingLot.models.ParkingSlot;
import src.ParkingLot.models.VehicleType;

import java.util.ArrayList;

public class FourWheelerParkingManager extends ParkingManager {
    private static final int SIZE = 20;

    public FourWheelerParkingManager() {
        super(SIZE);
    }


    @Override
    public void initializeParkingSlots(int size) {
        parkingSlots = new ArrayList<>();
        for (int i=0; i<SIZE; i++) {
            parkingSlots.add(new ParkingSlot(VehicleType.FOUR_WHEELER, "B" + i));
        }
    }
}
