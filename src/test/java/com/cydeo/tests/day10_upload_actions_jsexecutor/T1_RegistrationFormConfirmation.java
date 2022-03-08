package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_RegistrationFormConfirmation {


    @Test
    public void registration_confirmation(){

        //Go to website: https://practice.cydeo.com/registration_form
        //Driver.getDriver().get("https://practice.cydeo.com/registration_form");
        // Driver.getDriver().get(url);
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        //create JavaFaker object
        Faker faker=new Faker();

        //Enter first name
        WebElement firstname = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys(faker.name().firstName());

        //Enter last name
        WebElement lastname=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys(faker.name().lastName());

        //Enter username
        WebElement username=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //username.sendKeys(faker.bothify("####???##"));
       // username.sendKeys(faker.bothify("helpdesk##"));
        String user= faker.bothify("helpdesk##");
        username.sendKeys(user);

        //Enter email address
        WebElement enterEmailAddress=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        enterEmailAddress.sendKeys(user + "@gmail.com");

        //Enter password
        WebElement enterPassword=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        enterPassword.sendKeys(faker.internet().password());
       // enterPassword.sendKeys(faker.numerify("##/$####??##"));
       // System.out.println("faker.internet().password() = " + faker.internet().password() );

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
        Select departmentDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(2);
        //departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));

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
/*
TC#1: Registration form confirmation
Note: Use JavaFaker OR read from configuration.properties file when possible.
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10. Enter date of birth
11. Select Department/Office
12. Select Job Title
13. Select programming language from checkboxes
14. Click to sign up button
15. Verify success message “You’ve successfully completed registration.” is
displayed.


Note:
1. Use new Driver utility class and method
2. User JavaFaker when possible
3. User ConfigurationReader when it makes sense
 */
