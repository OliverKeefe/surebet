package org.surebet;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataAssembler {

    public DataAssembler() {}

    // First combine runners and odds from DataScrapper class,

    // Then, Assign market name and standard market name (ID all markets within surebet will be assigned)

    // Then, assign sport category in final individual data structure

    // Finally, add to database

    // Final structure should look something like this: [Sport: Formula 1, Market: [Standard Name: WDC, SportsBook Name: World Driver Championship, [Runner: Max Verstappen, Odds: 10/1]]]
    protected HashMap<String, String> runnersAssemble (ArrayList<String> runners, ArrayList<String> odds, int[] maximumRunnersInMarket) {

        HashMap<String, String> runnersAndOdds = new HashMap<>();

        for (int i = maximumRunnersInMarket[0]; i < maximumRunnersInMarket[1]; i++) {
            runnersAndOdds.put(runners.get(i), odds.get(i));
        }

        return runnersAndOdds;
    }

    public final Map<String, Object> marketAssemble(String sport, String genre, String standardMarketName, String marketName, String sportsBook, HashMap<String, String> runnersAndOdds) {

        Map<String, Object> market = new HashMap<>();

        market.put("Sport", sport);
        market.put("Genre", genre);
        market.put("Standard Market Name", standardMarketName);
        market.put("Market Name", marketName);
        market.put("SportsBook", sportsBook);
        market.put("Market", new HashMap<String, Object>() {{
            put("Runners", runnersAndOdds);
        }});

        return market;

            //@Override
            //public String getSQLTypeName() throws SQLException {
            //    return "";
            //}
//
            //@Override
            //public Object[] getAttributes() throws SQLException {
            //    return new Object[0];
            //}
//
            //@Override
            //public Object[] getAttributes(Map<String, Class<?>> map) throws SQLException {
            //    return new Object[0];
            //}
    }
}
