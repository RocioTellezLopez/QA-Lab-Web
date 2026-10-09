package com.nttdata.steps;

import com.nttdata.page.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps {

    private WebDriver driver;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement getTitleCart = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.titleCart));
        return getTitleCart.getText();
    }

    public double convertToNum(String string) {
        return Double.parseDouble(
                string.replaceAll("[^0-9.]", "")
        );
    }

    public boolean validatePriceCart() {
        String price = driver.findElement(CartPage.price).getText();
        String quantity = driver.findElement(CartPage.quantityItem).getDomProperty("value");
        String total = driver.findElement(CartPage.totalPrice).getText();

        double unitPrice = convertToNum(price);
        double quantityNum = Integer.parseInt(quantity.trim());

        double totalPrice = convertToNum(total);
        double totalExpected = unitPrice * quantityNum;

        return Math.abs(totalExpected - totalPrice) < 0.000001;
    }
}
