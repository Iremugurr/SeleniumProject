package com.testinium.page;

import com.testinium.methods.Methods;
import org.openqa.selenium.By;

public class PointCataloguePage {
    Methods methods;

    public PointCataloguePage(){
        methods = new Methods();
    }

    public void point(){
        methods.click(By.cssSelector(".logo-text"));
        methods.waitBySecond(3);
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySecond(2);
        methods.selectByText(By.xpath("//*[@class='sort']/select"), "Yüksek Oylama");
        methods.waitBySecond(2);
        methods.hover(By.xpath("//*[@class='mn-strong common-sprite' and contains(text(),'Tüm Kitaplar')]"));
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@class='mn-icon icon-angleRight' and contains(text(),'Hobi')]"));
        methods.waitBySecond(2);
    }


    public void addRandomItem() {
    }
}
