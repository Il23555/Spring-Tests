package com.example.sweater.controller;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void successLoginTest() {
        Assert.assertTrue(loginPage.atPage());
        loginPage.inputLogin("ilyuza");
        loginPage.inputPasswd("8899");
        loginPage.clickLoginBtn();
        Assert.assertTrue(mainPage.atPage());
        mainPage.userLogout();
    }

    @Test
    public void wrongLoginTest() {
        Assert.assertTrue(loginPage.atPage());
        loginPage.inputLogin("alga");
        loginPage.inputPasswd("123");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.atPage());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}