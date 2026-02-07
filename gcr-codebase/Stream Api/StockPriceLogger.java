import java.util.*;

public class StockPriceLogger {

    public static void main(String[] args) {

        // Simulated live stock price feed
        List<Double> stockPrices = List.of(
                120.50,
                121.75,
                119.80,
                122.30
        );

        System.out.println("Live Stock Price Updates:");

        // Using forEach() to display prices
        stockPrices.forEach(price ->
                System.out.println("Stock Price: ₹" + price)
        );
    }
}
