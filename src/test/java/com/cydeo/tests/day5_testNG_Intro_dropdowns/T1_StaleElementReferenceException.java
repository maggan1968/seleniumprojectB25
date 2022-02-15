package com.cydeo.tests.day5_testNG_Intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
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
        WebElement addElementWebElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementWebElementButton.click();

        Thread.sleep(3000);

//4. Verify “Delete” button is displayed after clicking.
        WebElement deleteWebElementButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        if (deleteWebElementButton.isDisplayed()) {
            System.out.println("Delete Button verification  is  PASSED ");
        } else {
            System.out.println(" Delete Button verification is  FAILED ");}

        Thread.sleep(3000);

//5. Click to “Delete” button.
        deleteWebElementButton.click();
//6. Verify “Delete” button is NOT displayed after clicking.
        driver.navigate().refresh();
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='Delete']"));
        if (buttons.isEmpty()) {
            System.out.println("Verifier  deleted DELETE BUTTON  :Passed ");
        } else {
            System.out.println("Verifier  deleted DELETE BUTTON :Failed");
        }
        driver.quit();
//USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

    }
}
