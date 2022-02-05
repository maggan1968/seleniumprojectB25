package com.cydeo.tests.day2_locators_FindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork1_TitleVerification {

    /*
    TC #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon | Etsy”
     */


    public static void main(String[] args) {
//Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//Go to https://www.etsy.com
        driver.get("https://www.etsy.com ");
//Search for “wooden spoon”
        WebElement googleSearchBox = driver.findElement(By.name("search_query"));
        googleSearchBox.sendKeys("wooden spoon" + Keys.ENTER);
//4. Verify title:
//Expected: “Wooden spoon | Etsy”
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title is expected. Verification passed.");
        } else {
            System.out.println("Title is NOT as expected. Verification failed");


            driver.close();
        }
    }
}