package com.selenium.course.tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavascriptExecutorTest extends TestUtil {

    @Test
    public void loginWithJSAction() throws InterruptedException {
        //elements on login page
        WebElement usernameInput = driver.findElement(By.cssSelector("[data-test=\"username\"]"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.name("login-button"));

        //Actions
        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys("standard_user");
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement linkedInLink = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/sauce-labs/']"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()", linkedInLink);
    }
}
