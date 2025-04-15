package src.ParkingLot.managers.parkingManagers;

import src.ParkingLot.managers.priceStrategy.FlatPriceStrategy;
import src.ParkingLot.models.ParkingSlot;
import src.ParkingLot.models.VehicleType;

import java.util.ArrayList;

public class FourWheelerParkingManager extends ParkingManager {
    private static final int SIZE = 20;
    private static final int FLAT_PRICE = 200;

    public FourWheelerParkingManager() {
        super(SIZE, new FlatPriceStrategy(FLAT_PRICE));
    }


    @Override
    public void initializeParkingSlots(int size) {
        parkingSlots = new ArrayList<>();
        for (int i=0; i<SIZE; i++) {
            parkingSlots.add(new ParkingSlot(VehicleType.FOUR_WHEELER, "B" + i));
        }
    }
}
