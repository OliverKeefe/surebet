package org.surebet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DataScrapper {
    private String targetUrl;

    public DataScrapper() {
        this.targetUrl = targetUrl;
    }

    public void oddsGet(String targetUrl) {

        try {
            Document doc = Jsoup.connect(targetUrl).get();

            Elements oddsElements = doc.select("span.btn-odds__label");

            // Check if any elements were found
            if (oddsElements.isEmpty()) {
                System.out.println("No elements found with the class 'btn-odds__label'");
            } else {
                System.out.println("Elements found: " + oddsElements.size());

                for (Element oddsElement : oddsElements) {
                    String oddsText = oddsElement.text();
                    System.out.println("Odds: " + oddsText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}