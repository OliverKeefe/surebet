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

/**
 * The DataScrapper class is responsible for scraping data from a target
 * sports book using Selenium WebDriver and Jsoup for HTML parsing.
 */
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

    /**
     * Connects to the target web page using the specified URL.
     *
     * @param targetUrl The URL of the target web page.
     */
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

    /**
     * Retrieves HTML elements from the web page using the specified CSS query.
     *
     * @param cssQuery The CSS query to select elements.
     * @return The selected elements.
     */
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

    /**
     * Extracts market names from the provided HTML elements.
     *
     * @param marketElements The elements containing market names.
     * @return A list of market names.
     */
    protected ArrayList<String> getMarketNames(Elements marketElements) {
        ArrayList<String> marketNames = new ArrayList<>();

        for (Element marketElement : marketElements) {
            marketNames.add(marketElement.text());
        }

        return marketNames;
    }

    /**
     * Extracts runner names from the provided HTML elements.
     *
     * @param runnersElements The elements containing runner names.
     * @return A list of runner names.
     */
    protected ArrayList<String> getRunners(Elements runnersElements) {
        ArrayList<String> runners = new ArrayList<>();

        for (Element runnerElement : runnersElements) {
            runners.add(runnerElement.text());
        }

        return runners;
    }

    /**
     * Extracts odds from the provided HTML elements.
     *
     * @param oddsElements The elements containing odds.
     * @return A list of odds.
     */
    protected ArrayList<String> getOdds(Elements oddsElements) {
        ArrayList<String> odds = new ArrayList<>();

        for (Element oddElement : oddsElements) {
            odds.add(oddElement.text());
        }

        return odds;
    }

    /**
     * Assembles a map of runners and their corresponding odds.
     *
     * @param runnerElements   The elements containing runner names.
     * @param oddsElements     The elements containing odds.
     * @param maximumRunners   The maximum number of runners to include.
     * @return A map where keys are runner names and values are odds.
     */
    protected HashMap<String, String> getMarkets(Elements runnerElements, Elements oddsElements, int maximumRunners) {
        HashMap<String, String> market = new HashMap<>();

        for (int i = 0; i < maximumRunners; i++) {
            System.out.println(runnerElements.get(i).text());
            System.out.println(oddsElements.get(i).text());
            market.put(runnerElements.get(i).text(), oddsElements.get(i).text());
        }

        return market;
    }

    /**
     * Closes the WebDriver instance.
     */
    protected void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
