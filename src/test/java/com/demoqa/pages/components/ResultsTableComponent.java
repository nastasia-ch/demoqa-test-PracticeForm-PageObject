package com.demoqa.pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsTableComponent checkVisible() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultsTableComponent checkResultsValue(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public ResultsTableComponent checkResultsArray(String key, String value[]) {
        for(int i=0; i< value.length; i++) {
            $(".table-responsive").$(byText(key)).parent().shouldHave(text(value[i]));
        }return this;
    }
}
