package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.FavouritePage;
import com.testinium.page.LoginPage;
import org.junit.Test;

public class FavouriteTest extends BaseTest {

    @Test

    public void favouriteTest(){
        LoginPage loginPage = new LoginPage();
    loginPage.login();

    FavouritePage favouritePage = new FavouritePage();

    favouritePage.deleteFavourite();
    }




}
