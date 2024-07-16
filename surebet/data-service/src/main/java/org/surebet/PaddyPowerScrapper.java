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

}
