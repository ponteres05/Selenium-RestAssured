package com.webshop;

import com.webshop.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDriven {

    private WebDriver driver;

    @BeforeTest
    public void setupDriver(){

        this.driver = new ChromeDriver();
    }

    @BeforeTest
    public void openWebShopApplication(){
        Common common = new Common(driver);

        common.openApplication();
    }

    @Test(priority = 1)

    public void successfulLogin(){
        LandingPage landingPage = new LandingPage(driver);
        Login login = new Login(driver);

        landingPage.goToLoginPage();
        login.fillInTheLoginFormAndClickLoginButton();
        login.verifyThatCorrectErrormessageIsReceived();
    }

}
