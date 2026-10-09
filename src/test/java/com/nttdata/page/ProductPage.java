package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductPage {
    public static By inputQuantity = By.id("quantity_wanted");
    public static By buttonUpQuantity = By.xpath("//button[contains(@class, 'bootstrap-touchspin-up')]");
    public static By buttonAddCart = By.xpath("//button[@data-button-action='add-to-cart']");
}
