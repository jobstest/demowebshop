package com.tricentis.demowebshop.registrationForm.helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tricentis.demowebshop.registrationForm.config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        String login = config.login();
        String password = config.password();

        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remoteDriver = System.getProperty("remoteDriver", "selenoid.autotests.cloud");
        String siteUrl = System.getProperty("url", "https://demowebshop.tricentis.com");

        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = siteUrl;
        Configuration.remote = "https://" + login + ":" + password + "@" + remoteDriver + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attachment.screenshotAs("Last screenshot");
        Attachment.pageSource();
        Attachment.browserConsoleLogs();
        Attachment.addVideo();
        closeWebDriver();
    }
}
