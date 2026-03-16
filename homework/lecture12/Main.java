import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TradingBot bot = new TradingBot();

        Map<String, TradingStrategy> strategyRegistry = Map.of(
                "CONTRARIAN", new ContrarianStrategy(),
                "TREND", new TrendFollowerStrategy(),
                "PANIC", new PanicDropStrategy()
        );

        bot.setStrategy(strategyRegistry.get("CONTRARIAN"));
        feedPrices(bot, List.of(150.0, 148.0, 145.0, 142.0));

        bot.setStrategy(strategyRegistry.get("TREND"));
        bot.clearPriceHistory();
        feedPrices(bot, List.of(144.0, 146.0, 149.0, 155.0));
    }

    private static void feedPrices(TradingBot bot, List<Double> prices) {
        for (double price : prices) {
            bot.addPrice(price);
            bot.evaluate();
        }
    }
}
