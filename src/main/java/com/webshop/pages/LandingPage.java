package com.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LandingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "ico-register")
    private WebElement registerLink;

    @FindBy(className = "ico-logout")
    private WebElement logoutLink;

    @FindBy(className = "ico-login")
    private WebElement loginLink;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToRegisterPage(){
        this.registerLink.click();
    }

    public void clickLogoutLink(){
        this.logoutLink.click();
    }

    public void verifyThatUserHasSuccessfullyLoggedOut(){
        boolean loginLinkExist = driver.findElement(By.className("ico-login")).isDisplayed();
        Assert.assertTrue(loginLinkExist);
    }

    public void goToLoginPage(){
        this.loginLink.click();
    }

}


