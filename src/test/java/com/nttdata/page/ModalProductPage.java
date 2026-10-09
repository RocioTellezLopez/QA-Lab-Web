package com.nttdata.page;

import org.openqa.selenium.By;

public class ModalProductPage {
    public static By successMessage = By.id("myModalLabel");
    public static By productPrice = By.xpath("//div[@id='blockcart-modal']//p[@class='product-price']");
    public static By quantityItem = By.xpath("//div[@id='blockcart-modal']//span[@class='product-quantity']/strong");
    public static By mountTotal = By.xpath("//div[@id='blockcart-modal']//p[@class='product-total']/span[@class='value']");
    public static By buttonProceedCheckout = By.xpath("//div[@id='blockcart-modal']//div[@class='cart-content-btn']/a");
}
