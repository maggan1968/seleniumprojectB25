package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POMPractice {

    LibraryLoginPage libraryLoginPage;

    @Test
    public void Required_field_error_message_test() {


//    TC #1: Required field error message test
//1- Open a chrome browser
//2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
//3- Do not enter any information
//4- Click to “Sign in” button
        LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.signInButton.click();
//5- Verify expected error is displayed:
//    Expected: This field is required.

        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void invalid_email_format_error_message_test() {
//    TC #2: Invalid email format error message test
//1- Open a Chrome browser
//2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com ");
//3- Enter invalid email format
       libraryLoginPage = new LibraryLoginPage();

        libraryLoginPage.inputUsername.sendKeys("somethingwrong");

        libraryLoginPage.signInButton.click();

//4- Verify expected error is displayed:
//    Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void library_negative_login() {

//    TC #3: Library negative login

        //1- Open a chrome browser
            //2- Go to: https://library1.cydeo.com
            Driver.getDriver().get("https://library1.cydeo.com");
           libraryLoginPage = new LibraryLoginPage();
        //3- Enter incorrect username or incorrect password
            Faker faker = new Faker();
            //libraryLoginPage.inputUsername.sendKeys(faker.internet().emailAddress());its working
            libraryLoginPage.inputUsername.sendKeys("wrong@username.com");

            //libraryLoginPage.inputPassword.sendKeys(faker.internet().password());its working
            libraryLoginPage.inputPassword.sendKeys("wrongpassword");

            libraryLoginPage.signInButton.click();


            //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
            Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        Driver.closeDriver();
        }
}
