package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestPracticeFormWithPageObject {

    // Input data
    String firstName = "Anna";
    String lastName = "Stone";
    String email = "ann-stone@gmail.com";
    String gender = "Female";
    String phoneNumber = "8000000000";
    String monthOfBirth = "January";
    String yearOfBirth = "1995";
    String dayOfBirth = "12";
    String[] subjects = {"Maths","English","Chemistry"};
    String[] hobbies = {"Music","Reading"};
    String pictureName = "raccoon.jpeg";
    String currentAddress = "Current address";
    String state = "NCR";
    String city = "Delhi";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormWithAllData() {

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .choosePicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .isResultsTableVisible()
                .checkResult("Student Name",firstName+" "+lastName)
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",phoneNumber)
                .checkResult("Date of Birth",dayOfBirth+" "+monthOfBirth+","+yearOfBirth)
                .checkResultArray("Subjects",subjects)
                .checkResultArray("Hobbies",hobbies)
                .checkResult("Picture",pictureName)
                .checkResult("Address",currentAddress)
                .checkResult("State and City",state+" "+city);
    }

    @Test
    void fillFormWithMinimumData() {

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .clickSubmit()
                .isResultsTableVisible()
                .checkResult("Student Name",firstName+" "+lastName)
                .checkResult("Gender",gender)
                .checkResult("Mobile",phoneNumber);
    }
}
