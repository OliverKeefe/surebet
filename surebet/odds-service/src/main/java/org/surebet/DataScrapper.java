package org.surebet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class DataScrapper {
    private String targetUrl;

    public DataScrapper() {
        this.targetUrl = targetUrl;
        String chromeDriverPath = "~/Tools/chrome-automation/chromedriver-linux64/chromedriver"; // Use the full path
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

    }

    public void oddsGet(String targetUrl) {

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        try {
            System.out.println("Connecting to the URL...");
            driver.get(targetUrl);
            Thread.sleep(5000);
            String pageSource = driver.getPageSource();
            System.out.println("Connected to target");

            Document doc = Jsoup.parse(pageSource);

            System.out.println("Selecting elements...");
            Elements oddsElements = doc.select("span.btn-odds__label");
            Elements driversElements = doc.select("p.outright-item__runner-name");

            // Check if any elements were found
            if (oddsElements.isEmpty()) {
                System.out.println("No elements found with the class 'btn-odds__label'");
            } else {
                System.out.println("Elements found: " + oddsElements.size() + "and" + driversElements.size());

                for (Element driverElement : driversElements) {
                    String driversText = driverElement.text();
                    System.out.println("Driver: " + driversText);
                }

                for (Element oddsElement : oddsElements) {
                    String oddsText = oddsElement.text();
                    System.out.println("Odds: " + oddsText);
                }

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}
