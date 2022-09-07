package com.tricentis.demowebshop.registrationForm.test;

import com.tricentis.demowebshop.registrationForm.helpers.TestBase;
import com.tricentis.demowebshop.registrationForm.pages.MainFormPages;
import com.tricentis.demowebshop.registrationForm.pages.RegistrationFormPages;
import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {

    RegistrationFormPages registrationFormPages = new RegistrationFormPages();
    MainFormPages mainFormPages = new MainFormPages();

    @Test
    void loginForm() {
        registrationFormPages.openPage()
                .setEmail("test_web_shop@mail.ru")
                .setPassword("Selenium123")
                .clickLoginButton();
        mainFormPages.checkEmailUser("test_web_shop@mail.ru");
    }
}
