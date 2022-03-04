package com.cydeo.tests.day9_PropertiesReview_Javafaker_TestBase_DriverUtility_SingletonDesignPattern;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){

        //creating Faker object to reach method
        Faker faker = new Faker();
       // Faker faker = new Faker(new Locale("pl"));

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.name().title() = " + faker.name().title());
        System.out.println("faker.address().streetName() = " + faker.address().streetName());

        //numerify() method will generate random numbers in the format we want to get
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"773-###-####\") = " + faker.numerify("773-###-####"));

        //letterify() method will generate random letters in the format we want to get
        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));

        System.out.println("faker.animal().name() = " + faker.animal().name());

        System.out.println("faker.bothify(\"##??##-##????-##\") = " + faker.bothify("##??##-##????-##"));
        System.out.println("faker.number().randomDigitNotZero() = " + faker.number().randomDigitNotZero());
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.finance().creditCard().replaceAll(\"-\", \"\") = " + faker.finance().creditCard().replaceAll("-", ""));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.chuckNorris().fact().replaceAll(\"ChuckNorris\",\"Muhtar\") = " + faker.chuckNorris().fact().replaceAll("ChuckNorris", "Muhtar"));
    }
}
