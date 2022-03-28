package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;

    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        methods = new Methods();
    }

    public void selectProduct() {
        methods.sendKeys(By.id("search-input"), "oyuncak");
        methods.waitBySecond(5);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySecond(3);
        methods.scrollWithAction(By.xpath("(//div[@class='grid_7 omega'])[7]"));
        methods.waitBySecond(3);
        methods.selectRandomFavorite(By.xpath("a[@class='add-t0-favorites']"));
        methods.waitBySecond(3);
        methods.hover(By.xpath("//*[@class='common-sprite' and contains(text(),'Listelerim')]"));
        methods.waitBySecond(1);
        methods.click(By.xpath("//li/a[contains(text(),'Favorilerim')]"));
        methods.waitBySecond(2);
        Assert.assertEquals("4",methods.getText(By.xpath("//*[@class='favorite-tag active']/span")));
        logger.info("Favorilerde bulunan ürün sayısı: "+methods.getText(By.xpath("//*[@class='favorite-tag active']/span")));
        methods.waitBySecond(2);
    }
}



