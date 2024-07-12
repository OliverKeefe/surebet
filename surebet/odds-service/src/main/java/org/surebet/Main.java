package org.surebet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DataScrapper dataScrapper = new DataScrapper();
        dataScrapper.oddsGet("https://www.paddypower.com/motor-sport");
    }
}