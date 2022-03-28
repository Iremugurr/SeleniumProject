package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.methods.Methods;
import com.testinium.page.BasketPage;
import com.testinium.page.LoginPage;
import org.junit.Test;

public class BasketTest extends BaseTest {
      @Test
      public void basketTest(){
            LoginPage loginPage = new LoginPage();
            loginPage.login();
            BasketPage basketPage = new BasketPage();
            basketPage.basketPage();
            basketPage.submitForm();
            basketPage.logout();
      }

}
