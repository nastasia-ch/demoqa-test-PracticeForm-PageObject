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
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#stateCity-wrapper");

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
        for (String currentValue : value) {
            subjectsInput.setValue(currentValue).pressEnter();
        } return this;
    }

    public RegistrationFormPage setHobbies(String[] value) {
        for (String currentValue : value) {
            hobbiesInput.$(byText(currentValue)).click();
        } return this;
    }

    public RegistrationFormPage choosePicture(String value) {
        pictureChoice.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage clickSubmit() {
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