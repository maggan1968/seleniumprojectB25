package com.cydeo.tests.day13_synchronization_fluentwait_explicitWaitPractices_FULLREVIEW;

import com.cydeo.pages.Double_Click_Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Double_Click_Test {

    @Test
    public void t1_double_click_test() {

        //    TC #1: Double Click Tes
        //1. Go to
//https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
//2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

//3. Double click on the text “Double-click me to change my text color.”
        Double_Click_Page double_click_page = new Double_Click_Page();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(double_click_page.textToDoubleElement).perform();
//4. Assert: Text’s “style” attribute value contains “red”.
        System.out.println("double_click_page.textToDoubleElement.getAttribute(\"style\") = " + double_click_page.textToDoubleElement.getAttribute("style"));

        String actualStyleAttributeValue = double_click_page.textToDoubleElement.getAttribute("style");
        String exeptionInStyleAttribute = "red";

        Assert.assertTrue(actualStyleAttributeValue.contains(exeptionInStyleAttribute));
    }
}

