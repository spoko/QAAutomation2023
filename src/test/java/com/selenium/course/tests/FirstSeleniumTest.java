package com.selenium.course.tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest extends TestUtil {
    private static final String ADD_TO_CARD_BUTTON_ID = "add-to-cart-sauce-labs-";


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
        Thread.sleep(1000);//shall never be used

        //Assert
        Assert.assertTrue(logoutLink.isDisplayed());
        profileMenuXBtn.click();
        Assert.assertTrue(productsPageTitle.isDisplayed());
        Assert.assertEquals(productsPageTitle.getText(), "PRODUCTS");
    }
}
