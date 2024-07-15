package org.surebet;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PaddyPowerScrapper extends DataScrapper {

    public PaddyPowerScrapper() {
        super();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        Map<String, Map<String, Map<String, String>>> sportData = new HashMap<>();
    }

    @Override
    public ArrayList<String> runnersGet(Elements runnersElements, Document doc) {
        ArrayList<String> runners = new ArrayList<>();

        for (Element runnerElement : runnersElements) {
            runners.add(runnerElement.text());
        }
        return runners;
    }

    @Override
    public ArrayList<String> oddsGet(Elements oddsElements, Document doc) {
        ArrayList<String> odds = new ArrayList<>();

        for (Element oddElement : oddsElements) {
            odds.add(oddElement.text());
        }
        return odds;
    }

    public Map<String, String> marketGet(Elements runnerElements, Elements oddsElements, int maximumRunners, Document doc) {
        Map<String, String> market = new HashMap<>();
        
        for (int i = 0; i <= maximumRunners; i++) {
            String runner = runnerElements.get(i).text();
            String odds = oddsElements.get(i).text();
            market.put(runner, odds);
        }

        return market;
    }


}
