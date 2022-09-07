package com.tricentis.demowebshop.registrationForm.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPages {

    //locators
    SelenideElement emailInput = $("#Email");
    SelenideElement passwordInput = $("#Password");
    SelenideElement loginButton = $("[value='Log in']");
    //actions

    public RegistrationFormPages openPage() {
        step("Открыть страницу аутентификации", () -> {
            open("/login");

        });
        return this;
    }

    public RegistrationFormPages setEmail(String value) {
        step("Заполнить поле Email", () -> {
            emailInput.setValue(value);
        });

        return this;
    }

    public RegistrationFormPages setPassword(String value) {
        step("Заполнить поле Password", () -> {
            passwordInput.setValue(value);
        });

        return  this;
    }

    public RegistrationFormPages clickLoginButton() {
        step("Нажать на кнопку Log In", () -> {
            loginButton.click();
        });

        return this;
    }

}
