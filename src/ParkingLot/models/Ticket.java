package src.ParkingLot.models;

import java.util.Date;

public class Ticket {
    private final Vehicle vehicle;
    private final ParkingSlot parkingSlot;
    private final Date startTime;

    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot, Date startTime) {
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
        this.startTime = startTime;
    }

    public ParkingSlot getParkingSlot() {
        return this.parkingSlot;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public VehicleType getVehicleType() {
        return vehicle.getVehicleType();
    }

    public void display() {
        System.out.println("Ticket Details:\n\tVehicle Number:" + vehicle.getVehicleNumber() + "\n\tParking Lot:" + parkingSlot.getSlotId() + "\n\tentry time: " + startTime);
    }
}
