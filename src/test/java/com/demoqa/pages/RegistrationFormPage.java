package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    // Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $(".react-datepicker-wrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureChoice = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            setState = $("#stateCity-wrapper"),
            setCity = $("#stateCity-wrapper");

    private final static String TITLE_TEXT = "Student Registration Form";

    // Actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day,String month,String year) {
        birthDateInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    public RegistrationFormPage setSubjects(String[] value) {
        for (int j=0; j<value.length; j++) {
            subjectsInput.setValue(value[j]).pressEnter();
        } return this;
    }

    public RegistrationFormPage setHobbies(String[] value) {
        for (int j=0; j<value.length; j++) {
            hobbiesInput.$(byText(value[j])).click();
        } return this;
    }

    public RegistrationFormPage chooseFile(String value) {
        pictureChoice.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        setState.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        setCity.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResults(String gender, String s) {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage isResultsTableVisible() {
        resultsTableComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResultsValue(key,value);
        return this;
    }

    public RegistrationFormPage checkResultArray(String key, String value[]) {
        resultsTableComponent.checkResultsArray(key,value);
        return this;
    }
}
