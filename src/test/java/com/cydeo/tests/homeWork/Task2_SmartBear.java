package com.cydeo.tests.homeWork;

import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2_SmartBear {


    //    TC#2: Smartbear software order placing
//1. Open browser
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//2. Go to website:
//    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
    }

    @Test
    public void setUpMethod() {
        WebElement usernameCredentials = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        usernameCredentials.sendKeys("Tester");

        //4. Enter password: “test”
        WebElement passwordCredentials = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passwordCredentials.sendKeys("test");

        //5. Click to Login button
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        //6. Click on Order
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();

//7. Select familyAlbum from product, set quantity to 2
        driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")).click();
        driver.findElement(By.xpath("//option[@value='FamilyAlbum']")).click();
        WebElement quantity= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.click();
        quantity.sendKeys(Keys.BACK_SPACE);
        quantity.sendKeys("2");

//8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//9. Fill address Info with JavaFaker
//• Generate: name, street, city, state, zip code
        Faker fake = new Faker();

        String name = fake.name().fullName();
        String street = fake.address().streetName();


        String city = fake.address().city();
        String state = fake.address().state();
        String zip = fake.address().zipCode();
        while (zip.length()>5){
            zip = fake.address().zipCode();
        }

        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")).sendKeys(zip);

//10. Click on “visa” radio button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();

//11. Generate card number using JavaFaker
        String cardNumber = fake.business().creditCardNumber();
        cardNumber=cardNumber.replace("-", "");

//12. Click on “Process”
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

//13. Verify success message “New order has been successfully added.”
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(cardNumber);
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")).sendKeys("21/23");


    }
}
