package com.tricentis.demowebshop.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("allure8")
@Feature("Регистрация")
public class RegisterTests extends BaseTests {

    Faker faker = new Faker();
    String incorrectEmail = faker.internet().emailAddress() + faker.random();
    Name firstName = faker.name();
    Name lastName = faker.name();
    String password = faker.internet().password();
    String incorrectPassword = faker.internet().password(1,5);

    @Test
    @Disabled
    @DisplayName("Ошибки на пустые поля в блоке 'Register'")
    void errorAllEmptyFieldsRegPage() {
        step("Открыть страницу", () -> {
            open("/register");
        });
        step("Нажать на кнопку 'Register'", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибок на пустые поля", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* First name is required."))
                    .shouldHave(text("* Last name is required."))
                    .shouldHave(text("* Email is required."))
                    .shouldHave(text("* Password is required."))
                    .shouldHave(text("* Password is required."));
        });
    }

    @Test
    @Disabled
    @DisplayName("Регистрация")
    void inputAllFieldsRegPage() {
        step("Открыть страницу Register", () -> {
            open("/register");
        });
        step("Нажать на радиокнопку Male", () -> {
            $("#gender-male").click();
        });
        step("Заполнить поле First name", () -> {
            $("#FirstName").setValue(String.valueOf(firstName));
        });
        step("Заполнить поле Last name", () -> {
            $("#LastName").setValue(String.valueOf(lastName));
        });
        step("Заполнить поле Email некорректной почтой", () -> {
            $("#Email").setValue(incorrectEmail);
        });
        step("Заполнить поле Password", () -> {
            $("#Password").setValue(password);
        });
        step("Заполнить поле Confirm password", () -> {
            $("#ConfirmPassword").setValue(password);
        });
        step("Нажать на кнопку 'Register'", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибок на пустые поля", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* Wrong email"));
        });
    }

    @Test
    @Disabled
    @DisplayName("Ошибка на некорректную почту в поле 'Email'")
    void errorIncorrectEmailsRegPag1e() {
        step("Открыть страницу Register", () -> {
            open("/register");
        });
        step("Заполнить поле Email некорректной почтой", () -> {
            $("#Email").setValue(incorrectEmail);
        });
        step("Нажать на кнопку 'Register'", () -> {
            $("#register-button").click();
        });
        step("Проверить наличие ошибок на пустые поля", () -> {
            $(By.xpath("//div[@class='page registration-page']"))
                        .shouldHave(text("* Wrong email"));
        });
    }
    @Test
    @AllureId("16711")
    @DisplayName("Ошибка на некорректную почту в поле Email")
    @Tag("web")
    void errorIncorrectEmailsRegPage() {
        step("Открыть страницу регистрации", () ->{
            open("/register");
        });
        step("В поле Email ввести некорректную почту", () ->{
            $("#Email").setValue(incorrectEmail);
        });
        step("Нажать на кнопку Register",() ->{
            $("#register-button").click();
        });
        step("Проверить наличие ошибки:  * Wrong email", () ->{
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("* Wrong email"));
        });
    }

    @Test
    @Disabled
    @DisplayName("Ошибка на некорректную почту в поле Password")
    @Tag("web")
    void errorIncorrectPasswordRegPage() {
        step("Открыть страницу регистрации", () ->{
            open("/register");
        });
        step("В поле Password ввести некорректную почту", () ->{
            $("#Password").setValue(incorrectPassword);
        });
        step("Нажать на кнопку Register",() ->{
            $("#register-button").click();
        });
        step("Проверить наличие ошибки:  The password should have at least 6 characters.", () ->{
            $(By.xpath("//div[@class='page registration-page']"))
                    .shouldHave(text("The password should have at least 6 characters."));
        });
    }
}
