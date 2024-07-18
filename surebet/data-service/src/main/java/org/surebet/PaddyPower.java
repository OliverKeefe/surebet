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

    HashMap<String, String> WDCBettingLines = new HashMap<>();
    HashMap<String, String> WDC = new HashMap<>();

    HashMap<String, String> WDCWithoutTitleLeaderBettingLines = new HashMap<>();
    HashMap<String, String> WDCWithoutTitleLeader = new HashMap<>();

    public PaddyPower() {
        super();
        this.runnersQuery = "p.outright-item__runner-name";
        this.oddsQuery = "span.btn-odds__label";
        this.marketsQuery = "div.accordion__title";
        this.targetUrl = "https://www.paddypower.com/motor-sport/formula-1";
    }

    public void clickAllTheThings() {
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
    public void getData() {
        connectToPage(targetUrl);

        try {
            clickAllTheThings();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        runnersElements = getElements(runnersQuery);
        System.out.println("Runners found: " + runnersElements.size());
        oddsElements = getElements(oddsQuery);
        System.out.println("Odds found: " + oddsElements.size());
        marketElements = getElements(marketsQuery);
        System.out.println("Markets found: " + marketElements.size());

        marketNames = getMarketNames(marketElements);
        runners = getRunners(runnersElements);
        odds = getOdds(oddsElements);

        WDCBettingLines = dataAssembler.assembleBettingLines(runners, odds, 0, 21);
        WDC = dataAssembler.assembleMarket("Formula 1", "Motorsport", "WDC", "Winner - Drivers Championship", "Paddy Power", WDCBettingLines);

        for (Map.Entry<String, String> entry : WDCBettingLines.entrySet()) {
            System.out.println("Runner: " + entry.getKey() + ", Odds: " + entry.getValue());
        }

        WDCWithoutTitleLeaderBettingLines = dataAssembler.assembleBettingLines(runners, odds, 22, 31);
        WDCWithoutTitleLeader = dataAssembler.assembleMarket("Formula 1", "Motorsport", "WDC Without Title Leader", "Betting Without Max Verstappen", "Paddy Power", WDCWithoutTitleLeaderBettingLines);

        for (Map.Entry<String, String> entry : WDCWithoutTitleLeaderBettingLines.entrySet()) {
            System.out.println("Runner: " + entry.getKey() + ", Odds: " + entry.getValue());
        }

        closeDriver();
    }
}
