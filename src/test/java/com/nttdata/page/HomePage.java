package com.nttdata.page;

import org.openqa.selenium.By;

public class HomePage {
    public static By buttonLogin = By.xpath("//div[@id='_desktop_user_info']//a");
    public static By category(String name) {
        return By.xpath("//ul[@id='top-menu']//a[contains(@href, '-" + name.toLowerCase() + "')]");
    }
    public static By buttonLogout = By.xpath("//a[contains(@class,'logout')]");
}
