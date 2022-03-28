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


    public void submitForm() {
        methods.click(By.xpath("//*[contains(text(),'Yeni bir adres kullanmak istiyorum.')]"));
        methods.waitBySecond(2);
        methods.sendKeys(By.id("address-firstname-companyname"), "İrem");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("address-lastname-title"), "Uğur");
        methods.waitBySecond(2);
        methods.selectByText(By.id("address-zone-id"), "Muratpaşa");
        methods.waitBySecond(2);
        methods.selectByText(By.id("address-county-id"), "ANTALYA");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("district"), "GÜZELOLUK Mahallesi");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("address-address-text"), "Yalı Cd. No:154,");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("address-postcode"), "07100");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("address-telephone"), "05389860932");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("address-tax-id"), "14128839147");
        methods.waitBySecond(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(1);
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".error")));
        String cardNameError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Kart sahibinin adı boş bırakılamaz!')]"));
        String cardNumberError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Kart numarası alanı 16 karakter olmalı!')]"));
        String cardValidateError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Kartınızın son kullanım tarihini (ay/yıl) seçiniz!')]"));
        String cardCvvError = methods.getText(By.xpath("//span[@class='error' and contains(text(),'Güvenlik kodu boş bırakılamaz!')]"));
        logger.info("Kart Girilmeden Alınan Hata Mesajları: " + cardNameError + "\n" + cardNumberError + "\n" + cardValidateError + "\n" + cardCvvError);
        methods.waitBySecond(1);
    }

    public void logout() {
        methods.click(By.cssSelector(".checkout-logo"));
        methods.waitBySecond(3);
        methods.hover(By.cssSelector(".common-sprite"));
        methods.waitBySecond(3);
        methods.click(By.xpath("//*[contains(text(),'Çıkış')]"));
        methods.waitBySecond(3);
    }

}


