package org.surebet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaddyPower extends DataScrapper implements Bookmaker {

    DataAssembler dataAssembler = new DataAssembler();
    HashMap<String, String> WDCMarketLines = new HashMap<>();
    HashMap<String, String> WDCMarket = new HashMap<>();

    public PaddyPower() {
        super();
        this.runnersQuery = "p.outright-item__runner-name";
        this.oddsQuery = "span.btn-odds__label";
        this.marketsQuery = "div.accordion__title";
        this.targetUrl = "https://www.paddypower.com/motor-sport/formula-1";
    }

    private void clickAllTheThings() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Find and click the 'Allow all cookies' button
        try {
            WebElement acceptAllButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            js.executeScript("arguments[0].click();", acceptAllButton);
            Thread.sleep(3000); // Wait for the page to process the click
        } catch (Exception e) {
            System.out.println("Accept All button not found or could not be clicked: " + e.getMessage());
        }

        // Find and click all dropdown headers
        try {
            List<WebElement> dropdownHeaders = driver.findElements(By.cssSelector(".accordion__header"));
            for (WebElement header : dropdownHeaders) {
                wait.until(ExpectedConditions.visibilityOf(header));
                js.executeScript("arguments[0].scrollIntoView(true);", header);
                js.executeScript("arguments[0].click();", header);
                Thread.sleep(500); // Wait between clicks to avoid issues with rapid clicks
            }
        } catch (Exception e) {
            System.out.println("Error while clicking dropdown headers: " + e.getMessage());
        }

        // Find and click all 'Show more' links
        try {
            List<WebElement> showMoreLinks = driver.findElements(By.cssSelector("abc-link.outright-item-show-all a.link__container--with-divider"));
            for (WebElement link : showMoreLinks) {
                js.executeScript("arguments[0].scrollIntoView(true);", link);
                js.executeScript("arguments[0].click();", link);
                Thread.sleep(500); // Wait between clicks to avoid issues with rapid clicks
            }
        } catch (Exception e) {
            System.out.println("Error while clicking 'Show more' links: " + e.getMessage());
        }

    }

    @Override
    public void assignDataToMarkets() {
        connectToPage(targetUrl);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickAllTheThings();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runnersElements = getElements(runnersQuery);
        oddsElements = getElements(oddsQuery);
        marketElements = getElements(marketsQuery);

        marketNames = getMarketNames(marketElements);
        runners = getRunners(runnersElements);
        odds = getOdds(oddsElements);

       WDCMarketLines = getMarkets(runnersElements, oddsElements, runnersElements.size());

        //int[] max = new int[2];
        //max[0] = 0;
        //max[1] = 10;
        //WDCMarketLines = dataAssembler.runnersAssemble(runners, odds, max);

        for (Map.Entry<String, String> entry : WDCMarketLines.entrySet()) {
            System.out.println("Runner: " + entry.getKey() + ", Odds: " + entry.getValue());
        }

        WDCMarket = dataAssembler.marketAssemble("Formula 1", "Motorsport", "WDC", "Winner - Drivers Championship", "Paddy Power", WDCMarketLines);

        closeDriver();
    }
}
