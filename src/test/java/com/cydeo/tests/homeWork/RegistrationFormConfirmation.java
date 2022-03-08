package com.cydeo.tests.homeWork;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationFormConfirmation extends TestBase {


    @Test
    public void registration_confirmation(){

        //Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get("https://practice.cydeo.com/registration_form");

        //Enter first name
        Faker faker=new Faker();
        WebElement firstname = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys(faker.name().firstName());

        //Enter last name
        WebElement lastname=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys(faker.name().lastName());
        //Enter username
        WebElement username=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(faker.bothify("####???##"));
        //Enter email address

        WebElement enterEmailAddress=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        enterEmailAddress.sendKeys(faker.internet().emailAddress());

        //Enter password
        WebElement enterPassword=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        enterPassword.sendKeys(faker.internet().password());

        //Enter phone number
        WebElement enterPhoneNumber=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        enterPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        //Select a gender from radio buttons
        WebElement genderRadioButtons=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        genderRadioButtons.click();


        //Enter date of birth
        WebElement dateOfBirth=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys(faker.numerify("12/25/1945"));

        //Select Department/Office
        Select select=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByIndex(2);

        //Select Job Title
        Select jobTitle=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(5);

        //Select programming language from checkboxes
        Driver.getDriver().findElement(By.xpath("//input[@value='java']")).click();

        //Click to sign up button
        Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']")).click();

        //Verify success message “You’ve successfully completed registration!” is
        //displayed.

        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//p")).getText(),"You've successfully completed registration!");

    }




}

