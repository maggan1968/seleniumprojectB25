package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5HW_StateDropeDown {

    //TC #5: Selecting state from State dropdown and verifying result
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void SelectStateFromStateDropdownTest() throws InterruptedException {

        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3.Select Illinois
        Thread.sleep(2000);
        dropDown.selectByValue("IL");
        //4. Select Virginia
        Thread.sleep(2000);
        dropDown.selectByIndex(47);

        // 5. Select California
        Thread.sleep(2000);
        dropDown.selectByVisibleText("California");


        //6. Verify final selected option is California.

        WebElement currentSelectedOption = dropDown.getFirstSelectedOption();
        String acctualSelectesStateText = currentSelectedOption.getText();

        //String expectedStateDropdownText = "California1";
        // Assert.assertEquals(acctualSelectesStateText,expectedStateDropdownText, "Not passed");

        String expectedStateDropdownText = "California";
        Assert.assertEquals(acctualSelectesStateText,expectedStateDropdownText );
    }


}
