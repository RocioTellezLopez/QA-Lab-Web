package com.nttdata.steps;

import com.nttdata.page.HomePage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    private void navigateLoginPage () {
        WebElement clickButtonLogin = driver.findElement(HomePage.buttonLogin);
        clickButtonLogin.click();
    }

    public void inputUserMail (String userMail) {
        WebElement mailInputElement = driver.findElement(LoginPage.mailInput);
        mailInputElement.sendKeys(userMail);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.buttonSignIn));
    }

    public void inputPassword (String password) {
        WebElement inputPasswordElement = driver.findElement(LoginPage.passwordInput);
        inputPasswordElement.sendKeys(password);
    }

    public void clickSignIn () {
        WebElement buttonSignInElement = driver.findElement(LoginPage.buttonSignIn);
        buttonSignInElement.click();
    }

    public void loginWithEmailPassword (String mail, String password) {
        navigateLoginPage();
        inputUserMail(mail);
        inputPassword(password);
        clickSignIn();
    }

    public boolean isLoginSuccess () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(HomePage.buttonLogout)
        ).isDisplayed();
    }
}
