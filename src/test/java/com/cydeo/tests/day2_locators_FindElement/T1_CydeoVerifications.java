package com.cydeo.tests.day2_locators_FindElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {

        /*
        TC #1: Cydeo practice tool verifications
               1. Open Chrome browser
               2. Go to https://practice.cydeo.com
               3. Verify URL contains
                  Expected: cydeo
               4. Verify title:
                  Expected: Practice
         */

        //do set up for browser driver
        WebDriverManager.chromedriver().setup();

        //1. Open Chrome browser
        WebDriver driver= new ChromeDriver();

        //2 make our page fullscreen
        driver.manage().window().maximize();

        //3. Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //4.Verify URL contains
        System.out.println("driver.getCurrentUrl() = " +driver.getCurrentUrl());

        //5. get the page source of html
        System.out.println("driver.getPageSource() =" + driver.getPageSource());

        //6.Verify title:
        String expectedTitle = "Practice";

        //7. actual title comes from the browser
        String actualTitle = driver.getTitle();

    if (actualTitle.equals(expectedTitle)){
        System.out.println("Title is expected. Verification Passed");
    }else {
        System.out.println("Title is NOT as expected. Verification Failed");


        driver.quit();
}
    }
}
