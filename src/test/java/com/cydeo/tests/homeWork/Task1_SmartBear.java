package com.cydeo.tests.homeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1_SmartBear {

    //TC #1: SmartBear software link verification
//1. Open browser
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

    }

    @Test
    public void setUpMethod() throws InterruptedException {
        //3. Enter username: “Tester”
        WebElement usernameCredentials = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        usernameCredentials.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement passwordCredentials = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passwordCredentials.sendKeys("test");

        //5. Click to Login button
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        Thread.sleep(3000);
        //6. Print out count of all the links on landing page
        List<WebElement> allLinks=driver.findElements(By.xpath("//*[contains(@href, 'aspx')]") );
        System.out.println("Count of all links: " + allLinks.size());

        //7. Print out each link text on this page
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
        }
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
        }

//    Mini-Task: CREATE A CLASS à SmartBearUtils
//• Create a method called loginToSmartBear
//• This method simply logs in to SmartBear when you call it.
//• Accepts WebDriver type as parameter



