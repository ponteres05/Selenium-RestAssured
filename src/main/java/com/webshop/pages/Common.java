package com.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.data;

import java.time.Duration;

public class Common {

    private WebDriver driver;
    private WebDriverWait wait;

    public Common(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void openApplication(){
        this.driver.get(data.url);
        this.driver.manage().window().maximize();
    }

    public void closeApplication(){
        this.driver.quit();
    }

}

