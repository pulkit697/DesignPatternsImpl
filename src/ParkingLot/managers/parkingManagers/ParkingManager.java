package src.ParkingLot.managers.parkingManagers;

import src.ParkingLot.managers.priceStrategy.PriceStrategy;
import src.ParkingLot.models.ParkingSlot;
import src.ParkingLot.models.Ticket;
import src.ParkingLot.models.Vehicle;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public abstract class ParkingManager {
    protected List<ParkingSlot> parkingSlots;
    private final PriceStrategy pricingStrategy;

    public ParkingManager(int size, PriceStrategy priceStrategy) {
        initializeParkingSlots(size);
        this.pricingStrategy = priceStrategy;
    }

    public abstract void initializeParkingSlots(int size);

    public ParkingSlot getVacantSlot() {
        for (ParkingSlot parkingSlot: parkingSlots) {
            if (parkingSlot.isVacant()) {
                return parkingSlot;
            }
        }
        return null;
    }

    public Ticket bookSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        parkingSlot.fillSlot();
        Date currentTime = Date.from(Instant.now());
        return new Ticket(vehicle, parkingSlot, currentTime);
    }

    public void unBookSlot(Ticket ticket) {
        if (ticket != null) {
            ParkingSlot parkingSlot = ticket.getParkingSlot();
            parkingSlot.freeSlot();
        } else {
            throw new RuntimeException("Invalid ticket");
        }

    }

    public void closeSlot(ParkingSlot parkingSlot) {
        if (parkingSlot.isVacant()) {
            parkingSlot.toggleVacancy();
        }
    }

    public int getBill(Ticket ticket) {
        return pricingStrategy.calculateBill(getTimeElapsedInMinutes(ticket.getStartTime()));
    }

    private int getTimeElapsedInMinutes(Date startTime) {
        Date currentTime = Date.from(Instant.now());
        long timeDifferenceInMillis = currentTime.getTime() - startTime.getTime();
        return (int) Math.ceil(timeDifferenceInMillis/(1000 * 60.0));
    }
}
