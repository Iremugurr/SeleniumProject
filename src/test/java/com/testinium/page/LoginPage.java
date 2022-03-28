package com.testinium.page;

import com.testinium.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage  {

    static Methods methods;

    public LoginPage(){
        methods = new Methods();
    }

    public static void login() {
        methods.waitBySecond(5);
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.waitBySecond(3);
        methods.sendKeys(By.id("login-email"),"iremugur3232@gmail.com");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("login-password"),"iremugur");
        methods.waitBySecond(3);
        methods.click(By.cssSelector(".popupCloseIcon"));
        methods.waitBySecond(3);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySecond(20);
        Assert.assertTrue(methods.isElementVisible(By.id("search-input")));
        methods.click(By.id("search-input"));






    }



}
