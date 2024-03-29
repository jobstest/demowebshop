package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tricentis.demowebshop.config.RemoteOrLocalConfig;
import com.tricentis.demowebshop.config.SelenoidConfig;
import com.tricentis.demowebshop.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTests {

    @BeforeAll
    static void setUp() {
        RemoteOrLocalConfig configRL = ConfigFactory.create(RemoteOrLocalConfig.class,System.getProperties());
        SelenoidConfig config = ConfigFactory.create(SelenoidConfig.class);
        String loginSelenoid = config.loginSelenoid();
        String passwordSelenoid = config.passwordSelenoid();
        String uniformResourceNameSelenoid = config.uniformResourceNameSelenoid();

        SelenideLogger.addListener("allure", new AllureSelenide());
        //Configuration.baseUrl = "https://demowebshop.tricentis.com/";
        RestAssured.baseURI = "https://demowebshop.tricentis.com/";
        //Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        //Configuration.browser = System.getProperty("browser", "chrome");
        //Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.remote = "https://" + loginSelenoid + ":" + passwordSelenoid + "@" + uniformResourceNameSelenoid +"/wd/hub/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        Configuration.browserSize = configRL.browserSize();
        Configuration.baseUrl = configRL.baseUrl();
        Configuration.browser = configRL.browser();
        Configuration.browserVersion = configRL.browserVersion();
        Configuration.remote = configRL.remote();
    }



    @AfterEach
    void addAttchments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
