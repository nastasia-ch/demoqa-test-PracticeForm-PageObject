package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {

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
        String[] subject = {"Maths","English"};
        String[] hobby = {"Music","Reading"};
        String address = "Current address";
        String state = "NCR";
        String city = "Delhi";

        // Open Form
        open("/automation-practice-form");

        // Close add
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // Fill form

        // Fill First name
        $("#firstName").setValue(firstName);

        // Fill Last name
        $("#lastName").setValue(lastName);

        // Fill Email
        $("#userEmail").setValue(email);

        // Fill Gender
        $("#genterWrapper").$(byText(gender)).click();

        // Fill Mobile number
        $("#userNumber").setValue(number);

        // Fill Date of Birth
        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").selectOptionContainingText(yearOfBirth);
        $(".react-datepicker__month").$(byText(dayOfBirth)).click();

        // Fill Subjects
        for (int j=0; j<subject.length; j++) {
            $("#subjectsInput").setValue(subject[j]).pressEnter();
        }

        // Fill Hobbies
        for (int i=0; i<hobby.length; i++) {
            $("#hobbiesWrapper").$(byText(hobby[i])).click();
        }

        // Add picture
        $("#uploadPicture").uploadFromClasspath("raccoon.jpeg");

        // Fill Current address
        $("#currentAddress").setValue(address);

        // Choose state
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        // Choose city
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        // Click Submit
        $("#submit").click();

        // Check results
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(Condition.text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(Condition.text(email));
        $(".table-responsive").shouldHave(Condition.text(gender));
        $(".table-responsive").shouldHave(Condition.text(number));
        $(".table-responsive").shouldHave(Condition.text(dayOfBirth+" "+monthOfBirth+","+yearOfBirth));
        for(int i=0; i< subject.length; i++) {
            $(".table-responsive").shouldHave(Condition.text(subject[i]));
        }
        for(int j=0; j< subject.length; j++) {
            $(".table-responsive").shouldHave(Condition.text(hobby[j]));
        }
        $(".table-responsive").shouldHave(Condition.text("raccoon.jpeg"));
        $(".table-responsive").shouldHave(Condition.text(address));
        $(".table-responsive").shouldHave(Condition.text(state+" "+city));

    }

}
