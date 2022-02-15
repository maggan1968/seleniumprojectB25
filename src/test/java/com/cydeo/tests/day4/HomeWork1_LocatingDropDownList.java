package com.cydeo.tests.day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HomeWork1_LocatingDropDownList {
    public static void main(String[] args) throws InterruptedException {



    //sett up chrome driver and open chrome
    WebDriver driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    //navigate to checkbox page from practice site
        driver.get("http://practice.cybertekschool.com/dropdown");

    // identify the select element
        WebElement dropdownElement= driver.findElement(By.id("dropdown"));
        Thread.sleep(3000);
        //wrap this element inside Select object
        Select selectObject = new Select(dropdownElement);
        Thread.sleep(3000);
        //use ready methods to select option
        selectObject.selectByIndex(2);//select 3rt item at index 2
        Thread.sleep(3000);
        selectObject.selectByValue("1");//select item with value attribute 1
        Thread.sleep(3000);
        selectObject.selectByVisibleText("Option 2");

        //quit the browser
       driver.quit();

    }
}
