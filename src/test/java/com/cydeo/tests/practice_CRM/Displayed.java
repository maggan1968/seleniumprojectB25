package com.cydeo.tests.practice_CRM;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Displayed {


    //CY2-6 : Window Handle practice
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://login2.nextbasecrm.com/stream/?login=yes
        driver.get("https://login2.nextbasecrm.com/stream/?login=yes");
    }

   // @Test
    //public void multiple_option_test() throws InterruptedException {
        //3. Four options should be displayed under the MORE tab:

        //identify the dropdown with multiple select option
      //  int index = 0;
       // Select multiItemDropDownMore= new Select(driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']")));
    //List<WebElement>listDropDownMore= multiItemDropDownMore.getOptions();

        //for (WebElement  each :  listDropDownMore) {
           // Thread.sleep(1500);
           // multiItemDropDownMore.selectByIndex(index++);
       // }
        //Thread.sleep(3000);

      // multiItemDropDownMore.deselectAll();
       // selectLanguagesDropDown.deselectAll();
        // File
        // Appreciation
        // Announcement
        // Workflow

    }

