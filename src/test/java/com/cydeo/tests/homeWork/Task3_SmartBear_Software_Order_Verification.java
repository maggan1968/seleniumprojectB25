package com.cydeo.tests.homeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task3_SmartBear_Software_Order_Verification {

//TC#3: SmartBear software order verification

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");

    }
@Test
public void setUpMethod(){
    WebElement usernameCredentials = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
    usernameCredentials.sendKeys("Tester");

    //4. Enter password: “test”
    WebElement passwordCredentials = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
    passwordCredentials.sendKeys("test");

    //5. Click to Login button
    driver.findElement(By.id("ctl00_MainContent_login_button")).click();


    //   2. Click on View all orders
    driver.findElement(By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']")).click();

    //   3. Verify Susan McLaren has order on date “01/05/2010”
    WebElement susanMcLaren = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']//td[contains(text(), 'Susan McLaren')]/following-sibling::td[3]"));
    String actual = susanMcLaren.getText();
    String expected = "01/05/2010";
    Assert.assertEquals(actual, expected);

}
}

