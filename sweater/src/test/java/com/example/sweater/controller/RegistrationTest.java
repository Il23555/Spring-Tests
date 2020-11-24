package com.example.sweater.controller;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("registrationpage"));
    }

    @Test
    public void registrationTestByCSS(){
        WebElement username = driver.findElement(By.cssSelector("input[name=username]"));
        username.sendKeys("margo");
        WebElement password = driver.findElement(By.cssSelector("input[name=password]"));
        password.sendKeys("12345678");
        WebElement regBtn = driver.findElement(By.cssSelector("input[name=SignUp]"));
        regBtn.click();
        Assert.assertEquals("Sign In", driver.getTitle());
    }

    @Test
    public void registrationTestByPath(){
        WebElement username = driver.findElement(By.xpath("/html/body/form/div[1]/label/input"));
        username.sendKeys("ilyuza");
        WebElement password = driver.findElement(By.xpath("/html/body/form/div[2]/label/input"));
        password.sendKeys("8899");
        WebElement regBtn = driver.findElement(By.xpath("/html/body/form/div[3]/input"));
        regBtn.click();
        Assert.assertEquals("Sign Up", driver.getTitle());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}