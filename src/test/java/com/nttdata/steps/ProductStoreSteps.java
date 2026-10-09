package com.nttdata.steps;

import com.nttdata.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductStoreSteps {
    private WebDriver driver;

    public ProductStoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateProduct() {
        WebElement navigateProductElement = driver.findElement(SubcategoryPage.itemProduct);
        navigateProductElement.click();
    }

    public void addQuantity(int quantity) {
        WebElement buttonUp = driver.findElement(ProductPage.buttonUpQuantity);
        for (int i = 1; i < quantity; i++) {
            buttonUp.click();
        }
    }

    public void clickButtonAddCart() {
        WebElement buttonAddCartElement = driver.findElement(ProductPage.buttonAddCart);
        buttonAddCartElement.click();
    }

    public void addQuantityProduct(int quantity) {
        navigateProduct();
        addQuantity(quantity);
        clickButtonAddCart();
    }

    public String getSucessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement getMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ModalProductPage.successMessage));
        return getMessage.getText();
    }

    public double convertToNum(String string) {
        return Double.parseDouble(
                string.replaceAll("[^0-9.]", "")
        );
    }

    public boolean validateTotalPrice () {
        String price = driver.findElement(ModalProductPage.productPrice).getText();
        String quantity = driver.findElement(ModalProductPage.quantityItem).getText();
        String total = driver.findElement(ModalProductPage.mountTotal).getText();

        double unitPrice = convertToNum(price);
        double quantityNum = Integer.parseInt(quantity.trim());

        double totalPrice = convertToNum(total);
        double totalExpected = unitPrice * quantityNum;

        return Math.abs(totalExpected - totalPrice) < 0.000001;
    }

    public void clickProcedToCheckout () {
        WebElement clikButtonCheckout = driver.findElement(ModalProductPage.buttonProceedCheckout);
        clikButtonCheckout.click();
    }


}
