package com.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.data;

import java.time.Duration;

public class Checkout {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingAddressCountryDropdown;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityField;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1Field;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipPostalCodeField;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumberField;

    @FindBy(className = "new-address-next-step-button")
    private WebElement billingAddressContinueButton;

    @FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
    private WebElement shippingAddressContinueButton;

    @FindBy(className = "shipping-method-next-step-button")
    private WebElement shippingMethodContinueButton;

    @FindBy(className = "payment-method-next-step-button")
    private WebElement paymentMethodContinueButton;

    @FindBy(className = "payment-info-next-step-button")
    private WebElement paymentInformationContinueButton;

    @FindBy(className = "confirm-order-next-step-button")
    private WebElement confirmButton;

    public Checkout(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void fillInBillingAddressForm() throws InterruptedException {
        this.billingAddressCountryDropdown.click();
        Thread.sleep(3000);
        this.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#BillingNewAddress_CountryId > option:nth-child(169)"))).click();
        this.cityField.sendKeys(data.city);
        this.address1Field.sendKeys(data.address1);
        this.zipPostalCodeField.sendKeys(data.zipCode);
        this.phoneNumberField.sendKeys(data.phoneNumber);
        this.billingAddressContinueButton.click();
    }

    public void selectAndAddNewShippingAddress() throws InterruptedException {
        Thread.sleep(3000);
        this.shippingAddressContinueButton.click();
    }
    public void selectShippingMethod() throws InterruptedException {
        Thread.sleep(3000);
        this.shippingMethodContinueButton.click();
    }

    public void selectPaymentMethod() throws InterruptedException {
        Thread.sleep(3000);
        this.paymentMethodContinueButton.click();
    }

    public void reviewPaymentInformation() throws InterruptedException {
        Thread.sleep(3000);
        this.paymentInformationContinueButton.click();
    }

    public void confirmOrder() throws InterruptedException {
        Thread.sleep(3000);
        this.confirmButton.click();
    }

    public void verifyThatOrderHasBeenSuccessfullyProcessed() throws InterruptedException {
        Thread.sleep(5000);
        WebElement n = driver.findElement (By.xpath ("//*[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals(n.getText(), "Your order has been successfully processed!");
    }

}
