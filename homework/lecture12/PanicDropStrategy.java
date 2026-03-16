import java.util.List;

public class PanicDropStrategy implements TradingStrategy {
    @Override
    public boolean shouldExecuteTrade(List<Double> priceHistory) {
        if (priceHistory.size() < 2) {
            return false;
        }

        double firstPrice = priceHistory.get(0);
        double latestPrice = priceHistory.get(priceHistory.size() - 1);

        return latestPrice < firstPrice * 0.9;
    }
}
