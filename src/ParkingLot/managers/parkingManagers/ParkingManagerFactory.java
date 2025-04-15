package src.ParkingLot.managers.parkingManagers;

import src.ParkingLot.models.VehicleType;

import java.util.HashMap;

public class ParkingManagerFactory {
    HashMap<VehicleType, ParkingManager> parkingManagersCache;
    private static ParkingManagerFactory INSTANCE;

    public static ParkingManagerFactory getInstance() {
        if (INSTANCE != null) {
            synchronized(ParkingManagerFactory.class) {
                if (INSTANCE != null) {
                    INSTANCE = new ParkingManagerFactory();
                }
            }
        }
        return INSTANCE;
    }

    private ParkingManagerFactory() {
        parkingManagersCache = new HashMap<>();
        parkingManagersCache.put(VehicleType.TWO_WHEELER, new TwoWheelerParkingManager());
        parkingManagersCache.put(VehicleType.FOUR_WHEELER, new FourWheelerParkingManager());
    }

    public ParkingManager getParkingManager(VehicleType vehicleType) {
        return parkingManagersCache.get(vehicleType);
    }
}
