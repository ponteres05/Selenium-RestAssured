package com.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.data;

import java.time.Duration;

public class Login {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "Email")
    private WebElement loginEmailField;

    @FindBy(id = "Password")
    private WebElement loginPasswordField;

    @FindBy(className = "login-button")
    private WebElement loginButton;


    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void fillInTheLoginFormAndClickLoginButton(){
        this.loginEmailField.sendKeys(data.email);
        this.loginPasswordField.sendKeys(data.password);
        this.loginButton.click();
    }

    public void verifyThatUserHasSuccessfullyLoggedIn(){
        boolean accountLinkExist = driver.findElement(By.className("account")).isDisplayed();
        Assert.assertTrue(accountLinkExist);
    }

    public void verifyThatCorrectErrormessageIsReceived(){
    }

}
