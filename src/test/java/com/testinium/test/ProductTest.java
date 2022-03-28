package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        LoginPage.login();
        productPage.selectProduct();
    }
    @Test
    public void selectProduct(){
        ProductPage productPage = new ProductPage();
        productPage.selectProduct();

    }









}







