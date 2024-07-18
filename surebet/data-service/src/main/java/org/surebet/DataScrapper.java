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

public class DataScrapper {
    protected ChromeOptions options;
    protected WebDriver driver;

    protected String targetUrl;
    protected String runnersQuery;
    protected String oddsQuery;
    protected String marketsQuery;

    protected Elements runnersElements;
    protected Elements oddsElements;
    protected Elements marketElements;

    protected ArrayList<String> runners = new ArrayList<>();
    protected ArrayList<String> odds = new ArrayList<>();
    protected ArrayList<String> marketNames = new ArrayList<>();
    protected Map<String, String> runnersAndOdds = new HashMap<>();

    public DataScrapper() {
        String chromeDriverPath = "drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        this.options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }

    protected void connectToPage(String targetUrl) {
        this.targetUrl = targetUrl;
        try {
            System.out.printf("Attempting to connect to %s%n", targetUrl);
            driver.get(targetUrl);
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to the page", e);
        }
    }

    protected Elements getElements(String cssQuery) {
        try {
            if (driver == null) {
                throw new RuntimeException("WebDriver not initialized.");
            }
            String pageSource = driver.getPageSource();
            Document doc = Jsoup.parse(pageSource);
            Elements elements = doc.select(cssQuery);

            if (elements.isEmpty()) {
                throw new RuntimeException("No elements found for query: " + cssQuery);
            }
            return elements;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get elements for query: " + cssQuery, e);
        }
    }

    protected ArrayList<String> getMarketNames(Elements marketElements) {
        ArrayList<String> marketNames = new ArrayList<>();

        for (Element marketElement : marketElements) {
            marketNames.add(marketElement.text());
        }

        return marketNames;
    }

    protected ArrayList<String> getRunners(Elements runnersElements) {
        ArrayList<String> runners = new ArrayList<>();

        for (Element runnerElement : runnersElements) {
            runners.add(runnerElement.text());
        }

        return runners;
    }

    protected ArrayList<String> getOdds(Elements oddsElements) {
        ArrayList<String> odds = new ArrayList<>();

        for (Element oddElement : oddsElements) {
            odds.add(oddElement.text());
        }

        return odds;
    }

    protected HashMap<String, String> getMarkets(Elements runnerElements, Elements oddsElements, int maximumRunners) {
        HashMap<String, String> market = new HashMap<>();

        for (int i = 0; i < maximumRunners; i++) {
            System.out.println(runnerElements.get(i).text());
            System.out.println(oddsElements.get(i).text());
            market.put(runnerElements.get(i).text(), oddsElements.get(i).text());
        }

        return market;
    }

    protected void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
