package com.example.sweater.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'username')]")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement passwdField;

    @FindBy(xpath = "//*[contains(@id, 'SignIn')]")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'username')]")));
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'password')]")));
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public boolean atPage() {
        boolean res = driver.getTitle().equals("Sign In");
        return res;
    }
}