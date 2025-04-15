package src.ParkingLot.managers.priceStrategy;

public class FlatPriceStrategy implements PriceStrategy {
    private final int FLAT_PRICE;

    public FlatPriceStrategy(int flatPrice) {
        this.FLAT_PRICE = flatPrice;
    }
    @Override
    public int calculateBill(int timeElapsedInMinutes) {
        return FLAT_PRICE;
    }
}
