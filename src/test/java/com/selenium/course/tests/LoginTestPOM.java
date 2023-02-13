package com.selenium.course.tests;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTestPOM extends TestUtil {

    @Test(dataProvider = "correctUsers")
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //prPage.addItemsToTheCart
    }

}
