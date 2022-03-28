package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BasketPage {
    Methods methods;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public BasketPage() {
        methods = new Methods();
    }
    public void basketPage() {
        methods.click(By.id("cart"));
        methods.waitBySecond(3);
        methods.click(By.id("js-cart"));
        methods.waitBySecond(3);
        String quantity = methods.getAttribute(By.xpath("//*[@name='quantity']"), "value");
        logger.info("Değişimden önceki ürün adeti: " + quantity);
        methods.clearInputArea(By.xpath("//*[@name='quantity']"));
        methods.waitBySecond(3);
        methods.sendKeys(By.xpath("//*[@name='quantity']"), "2");
        methods.waitBySecond(3);
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.waitBySecond(3);
        methods.click(By.xpath("//div[@class='right']/a"));
        methods.waitBySecond(3);
    }


}


