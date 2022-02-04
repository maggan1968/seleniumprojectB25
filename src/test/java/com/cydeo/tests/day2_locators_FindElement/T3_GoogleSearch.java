package com.cydeo.tests.day2_locators_FindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    /*    TC#3: Google search
    1- Open a chrome browser
    2- Go to: https://google.com
                3- Write “apple” in search box
    4- Click google search button
    5- Verify title:
        Expected: Title should start with “apple” word
    */
    public static void main(String[] args) {

        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Write “apple” in search box
        //4- Click google search button using Keys.ENTER
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("apple" + Keys.ENTER);// Keys.ENTER imitate click enter

        //5- Verify title:
        //    Expected: Title should start with “apple” word
        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTitle)) {
            System.out.println("Title is expected.Verification Passed");
        } else {
            System.out.println("Title is NOT as expected. Verification Failed ");

            driver.close();
        }
    }
}

