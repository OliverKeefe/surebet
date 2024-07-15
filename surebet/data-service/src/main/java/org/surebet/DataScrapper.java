package org.surebet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public abstract class DataScrapper {
    protected String targetUrl;

    public DataScrapper() {
        String chromeDriverPath = "/home/oliverkeefe/Development/surebet/surebet/drivers/chromedriver"; // Use the full path
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
    }


    //public abstract void sportGet(Map<String, Map<String, Map<String, String>>> sportData, String sport);

    public abstract ArrayList<String> runnersGet(Elements runnersElements, Document doc);

    public abstract ArrayList<String> oddsGet(Elements oddsElements, Document doc);

    //public abstract void categoriesGet(Map<String, Map<String, Map<String, String>>> sportData);

    //public abstract void marketsGet(Map<String, Map<String, Map<String, String>>> sportData);

}
