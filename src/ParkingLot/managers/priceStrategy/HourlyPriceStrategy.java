package src.ParkingLot.managers.priceStrategy;

public class HourlyPriceStrategy implements PriceStrategy {
    private final int hourlyCharge;

    public HourlyPriceStrategy(int hourlyCharge) {
        this.hourlyCharge = hourlyCharge;
    }

    @Override
    public int calculateBill(int timeElapsedInMinutes) {
        int timeElapsedInHours = (int) Math.ceil(timeElapsedInMinutes/60.0);
        return timeElapsedInHours * hourlyCharge;
    }
}
