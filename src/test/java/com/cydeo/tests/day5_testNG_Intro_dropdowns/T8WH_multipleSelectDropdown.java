package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8WH_multipleSelectDropdown {

    //TC #8: Selecting value from multiple select dropdown
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
    public void multipleSelectDropdown() throws InterruptedException {
        //3. Select all the options from multiple select dropdown.

        int index = 0;
        Select selectLanguagesDropDown = new Select(driver.findElement(By.name("Languages")));
        List<WebElement> listSelectDropDown = selectLanguagesDropDown.getOptions();
        for (WebElement each : listSelectDropDown) {
            Thread.sleep(1500);
            selectLanguagesDropDown.selectByIndex(index++);
        }
        Thread.sleep(1500);
        selectLanguagesDropDown.deselectAll();
        //driver.navigate().refresh();

    }
}


