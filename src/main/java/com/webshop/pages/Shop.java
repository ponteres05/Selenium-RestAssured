package com.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.data;

import java.time.Duration;

public class Shop {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "small-searchterms")
    private WebElement searchField;

    @FindBy(className = "search-box-button")
    private WebElement searchButton;

    @FindBy(className = "picture")
    private WebElement itemImage;

    @FindBy(id = "addtocart_31_EnteredQuantity")
    private WebElement quantityInputBox;

    @FindBy(id = "add-to-cart-button-31")
    private WebElement addToCartButton;


    public Shop(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void typeProductToSearchField(){
        this.searchField.sendKeys(data.product);
    }

    public void clickSearchButton(){
        this.searchButton.click();
    }

    public void searchProductItem(){
        this.typeProductToSearchField();
        this.clickSearchButton();
    }

    public void selectProductImage(){
        this.itemImage.click();
    }

    public void inputItemQuantity(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addtocart_31_EnteredQuantity")));
        this.quantityInputBox.clear();
        this.quantityInputBox.sendKeys(data.itemQuantity);
    }

    public void clickAddToCartButton(){
        this.addToCartButton.click();
    }

}
