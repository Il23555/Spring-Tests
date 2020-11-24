package com.example.sweater.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'SignOut')]")
    private WebElement logoutBtn;

    public void userLogout() {
        logoutBtn.click();
    }

    public boolean atPage() {
        boolean res = driver.getTitle().equals("Main");
        return res;
    }
}
