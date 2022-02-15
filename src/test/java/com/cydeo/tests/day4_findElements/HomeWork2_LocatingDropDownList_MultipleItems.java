package com.cydeo.tests.day4_findElements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HomeWork2_LocatingDropDownList_MultipleItems {

    public static void main(String[] args) {
        //sett up chrome driver and open chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to checkbox page from practice site
        driver.get("http://practice.cybertekschool.com/dropdown");

        //identify the dropdown with multiple select option
        WebElement multiItemDropDown= driver.findElement(By.name("Languages"));
        //wrap  this element into Select object
        Select multiItemSelect = new Select(multiItemDropDown);
        //check if this is a multi select list
        multiItemSelect.selectByIndex(3);
        multiItemSelect.selectByValue("c#");
        multiItemSelect.selectByVisibleText("Java");

        //deselect item
        multiItemSelect.deselectByIndex(3);
        multiItemSelect.selectByValue("c#");
        multiItemSelect.selectByVisibleText("Java");
        multiItemSelect.deselectAll();

        driver.quit();
    }
}
