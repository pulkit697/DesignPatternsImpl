package src.ParkingLot.models;

public class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
}
