package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_ScrollPractice {

    //    TC #4: Scroll practice
    @Test
    public void task_4_and_5() {


//1- Open a Chrome browser
//2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/ ");

//3- Scroll down to “Powered by CYDEO”
//Create object of Actions and pass our "driver" instance
        Actions actions = new Actions(Driver.getDriver());
//Locating cydeo link to be able to pass in the actions method
//a[@href='https://cydeo.com/']
        WebElement cydeoLink= Driver.getDriver().findElement(By.linkText("CYDEO")) ;
//4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).pause(2000).perform();


//    TC #5: Scroll practice 2
//1- Continue from where the Task 4 is left in the same test.
//2- Scroll back up to “Home” link using PageUP button
        WebElement homeLink =Driver.getDriver().findElement(By.linkText("Home"));
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        Driver.getDriver().close();
    }
}