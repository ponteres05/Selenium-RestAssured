package com.webshop;

import com.webshop.pages.Common;
import com.webshop.pages.LandingPage;
import com.webshop.pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDriven {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){

        this.driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void invalidUsername() throws IOException {
        Common common = new Common(driver);
        LandingPage landingPage = new LandingPage(driver);
        Login login = new Login(driver);

        common.openApplication();
        landingPage.goToLoginPage();
        login.fillInTheLoginFormAndClickLoginButton1();
        login.verifyThatCorrectErrormessageIsReceived1();
    }

    @Test(priority = 2)
    public void invalidPassword() throws IOException {
        Common common = new Common(driver);
        LandingPage landingPage = new LandingPage(driver);
        Login login = new Login(driver);

        common.openApplication();
        landingPage.goToLoginPage();
        login.fillInTheLoginFormAndClickLoginButton2();
        login.verifyThatCorrectErrormessageIsReceived2();
    }

    @Test(priority = 3)
    public void blankUsernameAndPassword() throws IOException {
        Common common = new Common(driver);
        LandingPage landingPage = new LandingPage(driver);
        Login login = new Login(driver);

        common.openApplication();
        landingPage.goToLoginPage();
        login.fillInTheLoginFormAndClickLoginButton3();
        login.verifyThatCorrectErrormessageIsReceived3();
        common.closeApplication();
    }
}
