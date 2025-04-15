package src.ParkingLot.managers.parkingManagers;

import src.ParkingLot.managers.priceStrategy.HourlyWithMaxPriceStrategy;
import src.ParkingLot.models.ParkingSlot;
import src.ParkingLot.models.VehicleType;

import java.util.ArrayList;

public class TwoWheelerParkingManager extends ParkingManager {
    private static final int SIZE = 20;
    private static final int HOURLY_PRICE = 20;
    private static final int MAX_PRICE = 100;

    public TwoWheelerParkingManager() {
        super(SIZE, new HourlyWithMaxPriceStrategy(HOURLY_PRICE, MAX_PRICE));
    }


    @Override
    public void initializeParkingSlots(int size) {
        parkingSlots = new ArrayList<>();
        for (int i=0; i<SIZE; i++) {
            parkingSlots.add(new ParkingSlot(VehicleType.TWO_WHEELER, "A" + i));
        }
    }
}
