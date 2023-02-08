package com.selenium.course.tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class FirstSeleniumTest extends TestUtil {

    @Test
    public void successfulLoginSauceDemo() throws InterruptedException {

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

        //elements on products page
        WebElement profileMenu = driver.findElement(By.id("react-burger-menu-btn"));
        WebElement profileMenuXBtn = driver.findElement(By.id("react-burger-cross-btn"));
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        WebElement productsPageTitle = driver.findElement(By.xpath("//span[text()='Products']"));
        //example of contains:
        //WebElement productsPageTitle = driver.findElement(By.xpath("//span[contains(text(),'Produc')]"));
        // //*[@id="item_4_title_link"]/div

        profileMenu.click();
        //Thread.sleep(1000);//shall never be used, instead use the following:

        //Explicit wait:
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait10.until(ExpectedConditions.visibilityOf(logoutLink));

        //Fluent wait example: - it gives us more power for the config part
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofSeconds(2)) //how often web driver will check for presence of the element
                        .ignoreAll(Collections.singleton(NoSuchElementException.class));

        fluentWait.until(ExpectedConditions.elementToBeClickable(logoutLink));

        //Assert
        Assert.assertTrue(logoutLink.isDisplayed());
        profileMenuXBtn.click();
        Assert.assertTrue(productsPageTitle.isDisplayed());
        Assert.assertEquals(productsPageTitle.getText(), "PRODUCTS");
    }
}
