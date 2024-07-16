package org.surebet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class DataScrapper {
    protected String targetUrl;

    public DataScrapper() {

        String chromeDriverPath = "/home/oliverkeefe/Development/surebet/surebet/drivers/chromedriver"; // Use the full path

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        Map<String, Map<String, Map<String, String>>> sportData = new HashMap<>();
    }



    //public abstract void sportGet(Map<String, Map<String, Map<String, String>>> sportData, String sport);

    public ArrayList<String> runnersGet(Elements runnersElements, Document doc) {
        ArrayList<String> runners = new ArrayList<>();

        for (Element runnerElement : runnersElements) {
            runners.add(runnerElement.text());
        }

        return runners;
    }

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

    //public abstract void categoriesGet(Map<String, Map<String, Map<String, String>>> sportData);

    //public abstract void marketsGet(Map<String, Map<String, Map<String, String>>> sportData);

}
