package org.surebet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> paddyPowerOdds = new ArrayList<>();
        ArrayList<String> paddyPowerRunners = new ArrayList<>();
        Map<String, String> market = new HashMap<>();
        String targetUrl = "https://www.paddypower.com/motor-sport/formula-1";
        String chromeDriverPath = "/home/oliverkeefe/Development/surebet/surebet/drivers/chromedriver"; // Use the full path
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        PaddyPowerScrapper paddyPowerScrapper = new PaddyPowerScrapper();

        try {
            System.out.println("Connecting to the URL...");
            driver.get(targetUrl);
            Thread.sleep(10000);
            String pageSource = driver.getPageSource();
            System.out.println("Connected to target");

            Document doc = Jsoup.parse(pageSource);

            System.out.println("Selecting elements...");
            Elements oddsElements = doc.select("span.btn-odds__label");
            Elements runnersElements = doc.select("p.outright-item__runner-name");

            // Check if any elements were found
            if (oddsElements.isEmpty() || runnersElements.isEmpty()) {
                System.out.println("No elements found with the specified classes");
            } else {
                System.out.println("Elements found: " + oddsElements.size() + " and " + runnersElements.size());
                paddyPowerOdds = paddyPowerScrapper.oddsGet(oddsElements, doc);
                paddyPowerRunners = paddyPowerScrapper.runnersGet(runnersElements, doc);

                for (String i : paddyPowerOdds) {
                    System.out.println(i);
                }

                for (String i : paddyPowerRunners) {
                    System.out.println(i);
                }
                //market = paddyPowerScrapper.marketGet(runnersElements, oddsElements, 20, doc);
                //for (Map.Entry<String, String> entry : market.entrySet()) {
                //    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}