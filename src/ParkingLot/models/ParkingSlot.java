package src.ParkingLot.models;

public class ParkingSlot {
    private final String slotId;
    private final VehicleType slotType;
    private boolean isVacant;

    public ParkingSlot(VehicleType slotType, String slotId) {
        this.slotType = slotType;
        this.slotId = slotId;
        this.isVacant = true;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void toggleVacancy() {
        this.isVacant = !this.isVacant;
    }

    public void fillSlot() {
        if (this.isVacant()) {
            this.isVacant = false;
        } else {
            throw new RuntimeException("Slot already in use");
        }
    }

    public void freeSlot() {
        if (!this.isVacant()) {
            this.isVacant = true;
        } else {
            throw new RuntimeException("Slot has already been freed");
        }
    }

    public VehicleType getSlotType() {
        return this.slotType;
    }

    public String getSlotId() {
        return this.slotId;
    }
}
