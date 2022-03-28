package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        jsdriver = (JavascriptExecutor) driver;


    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void click(By by) {

        findElement(by).click();
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
        logger.info("Sendkeys işlemi gerçekleşti");
    }

    public boolean isElementVisible(By by) {
        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            logger.info("False" + e.getMessage());
            return false;

        }

    }

    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));

    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public void scrollWithJavaScript(By by) {
        jsdriver.executeScript("arguments[0].scrollIntoView();", findElement(by));

    }

    public String getAttribute(By by, String attributeName) {
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public String getValue(By by) {

        return jsdriver.executeScript("return arguments[0].value;", findElement(by)).toString();
    }


   public void selectRandomFavourite(By by) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random rnd = new Random();
        while (numbers.size() < 4) {
          int random = rnd.nextInt(getAllProducts(by).size());
            if (!numbers.contains(random)) {
                scrollWithAction(By.xpath("//*[@class='product-cr'][" + random + "]"));
                waitBySecond(3);
                getAllProducts(by).get(random).click();
                numbers.add(random);
            }
        }
    }

    public void addToCart(By hover, By by) {
        Actions actions = new Actions(driver);
        Random rnd = new Random();
        int i = rnd.nextInt(getAllProducts(by).size());
        actions.moveToElement(getAllProducts(hover).get(i)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(getAllProducts(by).get(i))).click();
    }


    public void hover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).perform();
    }


    public String splitId(String text) {
        return text.replace("product-", "");
    }

    private List<WebElement> getAllProducts(By by) {
        return findAll(by);
    }

    private List<WebElement> findAll(By by) {
        return findAll(by);
    }


    public void clearInputArea(By xpath) {
    }

    public void selectRandomFavorite(By xpath) {
    }
}

