package com.tricentis.demowebshop.registrationForm.helpers;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUpSite() {
        Configuration.baseUrl = "https://demowebshop.tricentis.com";
    }
}
