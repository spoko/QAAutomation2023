package com.selenium.course.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    public WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup(); //Automatically downloads and prepare webdriver for the version of the browser
        driver = new ChromeDriver(); //uses the downloaded driver version
        //driver.manage().window().fullscreen();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulLoginSauceDemo() throws InterruptedException {
        //Open the test page
        driver.get("https://www.saucedemo.com/");

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
