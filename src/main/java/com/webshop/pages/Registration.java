package main.java.com.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.data;

import java.time.Duration;

public class Registration {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "gender-male")
    private WebElement maleRadioButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement registrationEmailField;

    @FindBy(id = "Password")
    private WebElement registrationPasswordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "register-continue-button")
    private WebElement continueButton;

    public Registration(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void fillInTheRegistrationFormAndClickRegisterButton(){
        this.maleRadioButton.click();
        this.firstNameField.sendKeys(data.firstName);
        this.lastNameField.sendKeys(data.lastName);
        this.registrationEmailField.sendKeys(data.email);
        this.registrationPasswordField.sendKeys(data.password);
        this.confirmPasswordField.sendKeys(data.confirmPassword);
        this.registerButton.click();
    }

    public void verifyThatRegistrationIsSuccessful(){
        WebElement m = driver.findElement (By.xpath ("//*[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(m.getText(), "Your registration completed");
    }

    public void clickContinueButton(){
        this.continueButton.click();
    }

}
