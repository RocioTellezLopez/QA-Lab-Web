package com.nttdata.stepsdefinitions;

import com.nttdata.page.CartPage;
import com.nttdata.steps.CartSteps;
import com.nttdata.steps.CategorySubcategorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.ProductStoreSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepDef {
    private WebDriver driver;
    private String url = "https://qalab.bensg.com/store";

    private ProductStoreSteps productStoreSteps(WebDriver driver) {
        return new ProductStoreSteps(driver);
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get(url);
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String mail, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginWithEmailPassword(mail, password);

        boolean result = loginSteps.isLoginSuccess();

        Assertions.assertTrue(result, "Error in login");
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        CategorySubcategorySteps categorySubcategorySteps = new CategorySubcategorySteps(driver);

        categorySubcategorySteps.navigateCategorySubcategory(category, subcategory);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int quantity) {
        productStoreSteps(driver).addQuantityProduct(quantity);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        String successMessage = productStoreSteps(driver).getSucessMessage();

        Assertions.assertTrue(successMessage.contains("Product successfully added to your shopping cart") || successMessage.contains("Producto añadido correctamente a su carrito de compra"));

        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {

        boolean result = productStoreSteps(driver).validateTotalPrice();

        Assertions.assertTrue(result, "The amount total is incorrect");
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        productStoreSteps(driver).clickProcedToCheckout();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {

        CartSteps cartSteps = new CartSteps(driver);
        String title = cartSteps.getTitleCart();

        Assertions.assertTrue(title.contains("SHOPPING CART")|| title.contains("CARRITO"));
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {

        CartSteps cartSteps = new CartSteps(driver);
        boolean priceResult = cartSteps.validatePriceCart();

        Assertions.assertTrue(priceResult, "The amount total is incorrect");
        screenShot();

    }
}
