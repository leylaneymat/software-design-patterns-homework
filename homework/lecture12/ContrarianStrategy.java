import java.util.List;

public class ContrarianStrategy implements TradingStrategy {
    @Override
    public boolean shouldExecuteTrade(List<Double> priceHistory) {
        if (priceHistory.size() < 4) {
            return false;
        }

        int lastIndex = priceHistory.size() - 1;
        double latestPrice = priceHistory.get(lastIndex);

        return latestPrice < priceHistory.get(lastIndex - 1)
                && latestPrice < priceHistory.get(lastIndex - 2)
                && latestPrice < priceHistory.get(lastIndex - 3);
    }
}
