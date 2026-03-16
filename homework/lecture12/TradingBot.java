import java.util.ArrayList;
import java.util.List;

public class TradingBot {
    private final List<Double> priceHistory = new ArrayList<>();
    private TradingStrategy strategy;

    public void setStrategy(TradingStrategy strategy) {
        this.strategy = strategy;
    }

    public void addPrice(double price) {
        priceHistory.add(price);
    }

    public void clearPriceHistory() {
        priceHistory.clear();
    }

    public void evaluate() {
        if (strategy == null || priceHistory.isEmpty()) {
            return;
        }

        if (strategy.shouldExecuteTrade(priceHistory)) {
            double latestPrice = priceHistory.get(priceHistory.size() - 1);
            System.out.println("Trade Executed at price: " + latestPrice);
        }
    }
}
