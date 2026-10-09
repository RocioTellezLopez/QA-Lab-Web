package com.nttdata.steps;

import com.nttdata.page.CategoryPage;
import com.nttdata.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategorySubcategorySteps {
    private WebDriver driver;

    public CategorySubcategorySteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateCategory(String category) {
        WebElement navigateCategoryElement = driver.findElement(HomePage.category(category));
        navigateCategoryElement.click();
    }

    public void navigateSubcategory(String subcategory) {
        WebElement navigateSubcategory = driver.findElement(CategoryPage.subCategory(subcategory));
        navigateSubcategory.click();
    }

    public void navigateCategorySubcategory(String category, String subcategory) {
        navigateCategory(category);
        navigateSubcategory(subcategory);
    }
}
