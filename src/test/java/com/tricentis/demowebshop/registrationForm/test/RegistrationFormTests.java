package com.tricentis.demowebshop.registrationForm.test;

import com.tricentis.demowebshop.registrationForm.helpers.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    @Test
    void loginForm() {
        step("Открыть страницу аутентификации", () -> {
            open("/login");

        });
        step("Заполнить поле Email", () -> {
            $("#Email").setValue("test_web_shop@mail.ru");
        });
        step("Заполнить поле Password", () -> {
            $("#Password").setValue("Selenium123");
        });
        step("Нажать на кнопку Log In", () -> {
            $("[value='Log in']").click();
        });
        step("Проверить отображение почты", () -> {
            $(".header-links-wrapper").shouldHave(text("test_web_shop@mail.ru"));
        });
    }
}
