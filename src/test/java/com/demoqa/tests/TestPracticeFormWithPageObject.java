package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeFormWithPageObject {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillForm() {

        // Input data
        String firstName = "Anna";
        String lastName = "Stone";
        String email = "ann-stone@gmail.com";
        String gender = "Female";
        String number = "8000000000";
        String monthOfBirth = "January";
        String yearOfBirth = "1995";
        String dayOfBirth = "12";
        String[] subjects = {"Maths","English","Chemistry"};
        String[] hobbies = {"Music","Reading"};
        String fileName = "raccoon.jpeg";
        String address = "Current address";
        String state = "NCR";
        String city = "Delhi";

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(number)
                .setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .chooseFile(fileName)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .isResultsTableVisible()
                .checkResult("Student Name",firstName+" "+lastName)
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",number)
                .checkResult("Date of Birth",dayOfBirth+" "+monthOfBirth+","+yearOfBirth)
                .checkResultArray("Subjects",subjects)
                .checkResultArray("Hobbies",hobbies)
                .checkResult("Picture",fileName)
                .checkResult("Address",address)
                .checkResult("State and City",state+" "+city);

    }

    @Test
    void fillFormWithMinimumData() {

        // Input data
        String firstName = "Anna";
        String lastName = "Stone";
        String gender = "Female";
        String number = "8000000000";

        // Open Form
        registrationFormPage.openPage();

        // Fill form

        // Fill First name
        $("#firstName").setValue(firstName);

        // Fill Last name
        $("#lastName").setValue(lastName);

        // Fill Gender
        $("#genterWrapper").$(byText(gender)).click();

        // Fill Mobile number
        $("#userNumber").setValue(number);

        // Click Submit
        $("#submit").click();

        // Check results
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(Condition.text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(Condition.text(gender));
        $(".table-responsive").shouldHave(Condition.text(number));

    }

}
