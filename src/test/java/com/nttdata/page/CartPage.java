package com.nttdata.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By titleCart = By.xpath("//div[@class='card-block']//h1[@class='h1']");
    public static By quantityItem = By.xpath("//input[contains(@class,'js-cart-line-product-quantity')]");
    public static By totalPrice = By.xpath("//div[contains(@class,'cart-total')]/span[@class='value']");
    public static By price = By.xpath("//div[@class='current-price']/span[@class='price']");
}
