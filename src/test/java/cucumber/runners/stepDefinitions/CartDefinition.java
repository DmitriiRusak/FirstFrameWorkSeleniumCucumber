package cucumber.runners.stepDefinitions;

import cucumber.context.TestContext;
import cucumber.domainObjects.Product;
import cucumber.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartDefinition {

    private final WebDriver driver;

    public CartDefinition(TestContext testContext){
        driver=testContext.driver;
    }

    @Then("I see {int} {product} in the cart")
    public void iSeeBlueShoesInTheCart(int namberOfProducts, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getNameOfProduct(),product.getName(),"The names of goods are not the same");
        Assert.assertEquals(cartPage.getQuantityOfTheProductInTheCart(),namberOfProducts,
                "The quqntity of the product is not the same");
    }

    @And("I am on the checkout page")
    public void iAmOnTheCheckoutPage() {
        new CartPage(driver).checkOutButtonClick();
    }
}
