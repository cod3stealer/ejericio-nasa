import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class api {
    public Map<String, Double> fetchCryptocurrencyPrices() throws IOException {
        String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd";

        Map<String, Double> prices = new HashMap<>();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            String response = readResponse(con); // Extract response reading logic
            Map<String, Object>[] responseObjects = parseJsonResponse(response); // Use Gson for parsing

            for (Map<String, Object> priceData : responseObjects) {
                String coinName = (String) priceData.get("id");
                Double coinPrice = (Double) priceData.get("current_price");
                prices.put(coinName, coinPrice);
            }

            return prices;
        } catch (IOException e) {
            throw e; // Re-throw IOException for caller handling
        }
    }

    // Helper method to read response
    private String readResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();
        return content.toString();
    }

    // Helper method to parse JSON response using Gson
    private Map<String, Object>[] parseJsonResponse(String response) {
        Gson gson = new Gson();
        return gson.fromJson(response, Map[].class); // Use generic Map type
    }

    public double exchange(String fromCoin, String toCoin, double amount) throws IOException {
        // Fetch current prices in one call
        Map<String, Double> prices = fetchCryptocurrencyPrices();

        // Check for valid coin symbols before calculations
        if (!prices.containsKey(fromCoin) || !prices.containsKey(toCoin)) {
            throw new IllegalArgumentException("Invalid coin symbol(s)");
        }

        Double fromPrice = prices.get(fromCoin);
        Double toPrice = prices.get(toCoin);

        // Validate non-zero prices to avoid division by zero
        if (fromPrice == 0 || toPrice == 0) {
            throw new RuntimeException("Price cannot be zero");
        }

        return (amount * fromPrice) / toPrice;
    }
}