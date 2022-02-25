package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_name_verify_test {
    //TC #1: Web table practice
   public WebDriver driver;

   @BeforeMethod
    public void setupMethod(){
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //1. Go to: https://practice.cydeo.com/web-tables
       driver.get("https://practice.cydeo.com/web-tables");

   }
   @Test
    public void order_name_verify_test() {
//locate the cell that has Bob Martin text in it
      WebElement bobMartinCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
      System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());
      //2. Verify Bob’s name is listed as expected.
      //Expected: “Bob Martin”
      String expectedBobName = "Bob Martin";
      String actuelBobName = bobMartinCell.getText();

      Assert.assertEquals(actuelBobName, expectedBobName);

      //3. Verify Bob Martin’s order date is as expected: 12/31/2021
      //alternative locator to bobMartinDataCell = "//td[.='Bob Martin']/../td[5]"
      WebElement bobMartinDataCell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
      System.out.println("bobMartinDataCell.getText() = " + bobMartinDataCell.getText());
      String expectedBobDate = "12/31/2021";
      String actualBobData = bobMartinDataCell.getText();

      Assert.assertEquals(actualBobData, expectedBobDate);
   }
      //We use the utility method we created.
      @Test
      public void test2(){

         String costumerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Alexandra Gray");
         System.out.println("costumerOrderDate1 = " + costumerOrderDate1);


         String costumerOrderDate2 = WebTableUtils.returnOrderDate(driver, "John Doe");
         System.out.println("costumerOrderDate2 = " + costumerOrderDate2);

      }

      //Using WebTableUtils.orderVerify(); method
      @Test
      public void test3(){
      WebTableUtils.orderVerify(driver, "Bart Fisher","01/16/2021");


      }
}







