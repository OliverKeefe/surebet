package org.surebet;

import java.util.ArrayList;
import java.util.HashMap;

public class DataAssembler {

    public DataAssembler() {}

    /**
     * Assembles betting lines by mapping runners to their respective odds within a specified range.
     *
     * @param runners       An ArrayList of runner names.
     * @param odds          An ArrayList of corresponding odds for the runners.
     * @param firstPosition The starting index (inclusive) of the range within the runners and odds lists to include.
     * @param lastPosition  The ending index (exclusive) of the range within the runners and odds lists to include.
     * @return A HashMap where the keys are runner names and the values are their respective odds.
     *
     * Example structure of the returned HashMap:
     * {
     *     "Max Verstappen": "10/1",
     *     "Lewis Hamilton": "5/1",
     *     "Lando Norris": "15/1"
     * }
     *
     * Example usage:
     * ArrayList<String> runners = new ArrayList<>(Arrays.asList("Max Verstappen", "Lewis Hamilton", "Lando Norri"));
     * ArrayList<String> odds = new ArrayList<>(Arrays.asList("10/1", "5/1", "15/1"));
     * HashMap<String, String> result = assembleBettingLines(runners, odds, 0, 3);
     */

    protected HashMap<String, String> assembleBettingLines(ArrayList<String> runners, ArrayList<String> odds, int firstPosition, int lastPosition) {

        HashMap<String, String> runnersAndOdds = new HashMap<>();

        for (int i = firstPosition; i < lastPosition; i++) {
            runnersAndOdds.put(runners.get(i), odds.get(i));
        }

        return runnersAndOdds;
    }

    /**
     * Assembles a market representation by mapping market details and runners with their respective odds.
     *
     * @param sport             The sport category (e.g., "Formula 1").
     * @param genre             The genre or category within the sport (e.g., "Motorsport").
     * @param standardMarketName The standardized name for the market (e.g., "WDC").
     * @param marketName        The name of the market as known in the sportsbook (e.g., "Winner - Drivers Championship").
     * @param sportsBook        The name of the sportsbook offering the market (e.g., "Paddy Power").
     * @param runnersAndOdds    A HashMap where the keys are runner names and the values are their respective odds.
     * @return A HashMap representing the complete market details including sport, genre, market names, sportsbook, and runners with odds.
     *
     * Example structure of the returned HashMap:
     * {
     *     "Sport": "Formula 1",
     *     "Genre": "Motorsport",
     *     "Standard Market Name": "WDC",
     *     "Market Name": "Winner - Drivers Championship",
     *     "SportsBook": "Paddy Power",
     *     "Market": {
     *         "Runners": {
     *             "Max Verstappen": "10/1",
     *             "Lewis Hamilton": "5/1"
     *         }
     *     }
     * }
     *
     * Example usage:
     * HashMap<String, String> runnersAndOdds = new HashMap<>();
     * runnersAndOdds.put("Max Verstappen", "10/1");
     * runnersAndOdds.put("Lewis Hamilton", "5/1");
     *
     * MarketAssembler assembler = new MarketAssembler();
     * HashMap<String, String> market = assembler.assembleMarket("Formula 1", "Motorsport", "WDC", "Winner - Drivers Championship", "Paddy Power", runnersAndOdds);
     */

    public final HashMap<String, String> assembleMarket(String sport, String genre, String standardMarketName, String marketName, String sportsBook, HashMap<String, String> runnersAndOdds) {

        HashMap<String, String> market = new HashMap<>();

        market.put("Sport", sport);
        market.put("Genre", genre);
        market.put("Standard Market Name", standardMarketName);
        market.put("Market Name", marketName);
        market.put("SportsBook", sportsBook);
        market.put("Market", String.valueOf(new HashMap<String, Object>() {{
            put("Runners", runnersAndOdds);
        }}));

        return market;

    }
}
