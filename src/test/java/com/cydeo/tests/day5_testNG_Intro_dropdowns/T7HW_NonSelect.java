package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7HW_NonSelect {

    // TC #7: Selecting value from non-select dropdown
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void NonSelect() throws InterruptedException {
        //3. Click to non-select dropdown
        WebElement nonSelect = driver.findElement(By.xpath("//a[@href='#']"));
        Thread.sleep(2000);
        nonSelect.click();

        //4. Select Facebook from dropdown
        WebElement selectFacebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        selectFacebook.click();
//5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - Log In or Sign Up";
        Assert.assertEquals(expectedTitle, actualTitle,"Title test Failed!");

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
