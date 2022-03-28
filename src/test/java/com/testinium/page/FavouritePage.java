package com.testinium.page;

import com.testinium.driver.BaseTest;
import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class FavouritePage {
    Methods methods;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public FavouritePage(){
        methods = new Methods();
    }

    public void deleteFavourite(){
        methods.hover(By.xpath("//*[@class='common-sprite' and contains(text(),'Listelerim')]"));
        methods.waitBySecond(3);
    }


}

