package com.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.data;
import utility.invalidLoginCredentials;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

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

    public void fillInTheLoginFormAndClickLoginButton1() throws IOException {
        invalidLoginCredentials d=new invalidLoginCredentials();
        ArrayList data=d.getData("Invalid Username TC");

        this.loginEmailField.sendKeys((CharSequence) data.get(1));
        this.loginPasswordField.sendKeys((CharSequence) data.get(2));
        this.loginButton.click();
    }

    public void verifyThatCorrectErrormessageIsReceived1() throws IOException {
        invalidLoginCredentials d=new invalidLoginCredentials();
        ArrayList data=d.getData("Invalid Username TC");

        WebElement n = driver.findElement (By.xpath ("//*[contains(text(),'Please enter a valid email address.')]"));
        Assert.assertEquals(n.getText(), data.get(3));
    }

    public void fillInTheLoginFormAndClickLoginButton2() throws IOException {
        invalidLoginCredentials d=new invalidLoginCredentials();
        ArrayList data=d.getData("Invalid Password TC");

        this.loginEmailField.sendKeys((CharSequence) data.get(1));
        this.loginPasswordField.sendKeys((CharSequence) data.get(2));
        this.loginButton.click();
    }

    public void verifyThatCorrectErrormessageIsReceived2() throws IOException {
        invalidLoginCredentials d=new invalidLoginCredentials();
        ArrayList data=d.getData("Invalid Password TC");

        WebElement n = driver.findElement (By.xpath ("//*[contains(text(),'The credentials provided are incorrect')]"));
        Assert.assertEquals(n.getText(), data.get(3));
    }

    public void fillInTheLoginFormAndClickLoginButton3() throws IOException {
        invalidLoginCredentials d=new invalidLoginCredentials();
        ArrayList data=d.getData("Blank Username and Password TC");

        this.loginEmailField.sendKeys((CharSequence) data.get(1));
        this.loginPasswordField.sendKeys((CharSequence) data.get(2));
        this.loginButton.click();
    }

    public void verifyThatCorrectErrormessageIsReceived3() throws IOException {
        invalidLoginCredentials d=new invalidLoginCredentials();
        ArrayList data=d.getData("Blank Username and Password TC");

        WebElement n = driver.findElement (By.xpath ("//*[contains(text(),'No customer account found')]"));
        Assert.assertEquals(n.getText(), data.get(3));
    }

}
