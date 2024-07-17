package org.surebet;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataAssembler {

    public DataAssembler() {}

    // Final structure should look something like this: [Sport: Formula 1, Market: [Standard Name: WDC, SportsBook Name: World Driver Championship, [Runner: Max Verstappen, Odds: 10/1]]]
    protected HashMap<String, String> runnersAssemble (ArrayList<String> runners, ArrayList<String> odds, int[] maximumRunnersInMarket) {

        HashMap<String, String> runnersAndOdds = new HashMap<>();

        for (int i = maximumRunnersInMarket[0]; i < maximumRunnersInMarket[1]; i++) {
            runnersAndOdds.put(runners.get(i), odds.get(i));
        }

        return runnersAndOdds;
    }

    public final HashMap<String, String> marketAssemble(String sport, String genre, String standardMarketName, String marketName, String sportsBook, HashMap<String, String> runnersAndOdds) {

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
