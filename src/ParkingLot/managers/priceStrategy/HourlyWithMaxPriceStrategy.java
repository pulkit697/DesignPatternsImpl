package src.ParkingLot.managers.priceStrategy;

public class HourlyWithMaxPriceStrategy implements PriceStrategy {
    private final int hourlyCharge;
    private final int MAX_BILL_AMOUNT;

    public HourlyWithMaxPriceStrategy(int hourlyCharge, int maxBillAmount) {
        this.hourlyCharge = hourlyCharge;
        this.MAX_BILL_AMOUNT = maxBillAmount;
    }

    @Override
    public int calculateBill(int timeElapsedInMinutes) {
        int timeElapsedInHours = (int) Math.ceil(timeElapsedInMinutes/60.0);
        return Math.min(MAX_BILL_AMOUNT, timeElapsedInHours * hourlyCharge);
    }
}
