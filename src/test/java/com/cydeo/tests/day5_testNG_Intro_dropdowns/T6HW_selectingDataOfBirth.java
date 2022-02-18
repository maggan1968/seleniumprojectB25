package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6HW_selectingDataOfBirth {
    //TC #6: Selecting date on dropdown and verifying
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
    public void selectingDataOfBirth(){

//3. Select “December 1st, 1923” and verify it is selected.

// Select year using  : visible text
        Select dropDownYear= new Select(driver.findElement(By.xpath("//select[@id='year']")));
        dropDownYear.selectByVisibleText("1923");
// Select month using   : value attribute
        Select dropDownMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
       dropDownMonth.selectByValue("11");
// Select day using : index number
        Select dropDownDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dropDownDay.selectByIndex(0);

        //creating expected values
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = dropDownYear.getFirstSelectedOption().getText();
        String actualMonth = dropDownMonth.getFirstSelectedOption().getText();
        String actualDay = dropDownDay.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);

driver.close();
    }
}
