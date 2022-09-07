package com.tricentis.demowebshop.registrationForm.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainFormPages {

    //locators
    SelenideElement emailUser = $(".header-links-wrapper");

    //actions
    public MainFormPages checkEmailUser(String value) {
        step("Проверить отображение почты", () -> {
            emailUser.shouldHave(text(value));
        });

        return  this;
    }

}
