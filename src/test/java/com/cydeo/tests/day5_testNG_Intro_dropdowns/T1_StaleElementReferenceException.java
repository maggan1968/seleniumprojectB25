package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementReferenceException {
    public static void main(String[] args) throws InterruptedException {



    /*
    XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: StaleElementReferenceException handling   */
//1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // providing extra wait time for out driver before it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/ ");
//3. Click to “Add Element” button
       // WebElement addElementWebElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        WebElement addElementWebElementButton = driver.findElement(By.xpath("//button[.='Add Element']"));

        Thread.sleep(3000);
        addElementWebElementButton.click();

//4. Verify “Delete” button is displayed after clicking.
        WebElement deleteWebElementButton = driver.findElement(By.xpath("//button[@class='added-manually']"));
        //System.out.println("deleteWebElementButton.isDisplayed = " + deleteWebElementButton.isDisplayed());
        if (deleteWebElementButton.isDisplayed()) {
            System.out.println("Delete Button verification  is  PASSED ");
        } else {
            System.out.println(" Delete Button verification is  FAILED ");}

        Thread.sleep(3000);

//5. Click to “Delete” button.
        deleteWebElementButton.click();
//6. Verify “Delete” button is NOT displayed after clicking.

        try {

            System.out.println("deleteWebElementButton.isDisplayed() = " + deleteWebElementButton.isDisplayed());

        }catch (StaleElementReferenceException e){

            System.out.println("-->StaleElementReferenceException exception is thrown");
            System.out.println("-->This means the web element is completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() = false");

        }

        driver.close();
    }
}
//USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS



