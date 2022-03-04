package com.cydeo.tests.homeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task4_Count_Link_On_Page {

    //    TC #1: Checking the number of links on the page
//1. Open Chrome browser
//2. Go to https://www.openxcell.com
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com");
    }

    @Test
    public void testName() {
        //3. Count the number of the links on the page and verify
//    Expected: 332
        List<WebElement> links = driver.findElements(By.cssSelector("a[href]"));
        int count = 0;
        for (WebElement link : links) {
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void printOutLinks() {
//        TC #2: Printing out the texts of the links on the page
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
//        3. Print out all of the texts of the links on the page
        List<WebElement> links = driver.findElements(By.cssSelector("a[href]"));
        for (WebElement link : links) {
            try {
                System.out.println(link.getText());
            } catch (StaleElementReferenceException e) {
            }
        }
    }

    @Test
    public void CountLinksWithoutText() {
//        TC #3: Counting the number of links that does not have text
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
//        3. Count the number of links that does not have text and verify
//        Expected: 109
        List<WebElement> links = driver.findElements(By.cssSelector("a[href]"));
        int countEmpty = 0;
        for (WebElement link : links) {
            try {
                if (link.getText().isEmpty())
                    countEmpty++;
            } catch (StaleElementReferenceException e) {
            }
        }
        System.out.println(countEmpty);
    }

}
