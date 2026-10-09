package com.nttdata.page;

import org.openqa.selenium.By;

public class CategoryPage {
    public static By subCategory(String name) {
        return By.xpath("//div[@id='subcategories']//a[@title='" + name + "']");
    }
}
