package cucumber.runners.stepDefinitions;

import cucumber.constants.EndPoints;
import cucumber.context.TestContext;
import cucumber.domainObjects.Product;
import cucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreDefinition {

    private final WebDriver driver;

    public StoreDefinition(TestContext testContext){
        driver=testContext.driver;
    }

    @Given("I am on the store page")
    public void iAmOnTheStorePage() {
        new StorePage(driver).load(EndPoints.STORE.url);
    }

    @When("I add {product} to the cart")
    public void iAddBlueShoesToTheCart(Product product){
        System.out.println("**************************************************************************************"+" "+product.getName());
        new StorePage(driver).addToCart(product.getName());
    }

    @Given("I am a customer")
    public void IAmACustomer(){
        new StorePage(driver).load(EndPoints.STORE.url);
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        new StorePage(driver).addToCart("Blue Shoes");
    }
}
