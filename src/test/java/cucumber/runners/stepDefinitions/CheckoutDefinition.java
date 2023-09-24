package cucumber.runners.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import cucumber.context.TestContext;
import cucumber.domainObjects.BillingDitails;
import cucumber.pages.CheckoutPage;

public class CheckoutDefinition {
    private final WebDriver driver;
    private BillingDitails billingDitails;

    public CheckoutDefinition(TestContext testContext){
        this.driver = testContext.driver;
    }

    @And("my billing details are") // this method is to bring the arguments from .feature fail.
    public void myBillingDetailsAre(BillingDitails billingDitails) {
        this.billingDitails=billingDitails;
    }

    @When("I provide Billing details")
    public void iProvideBillingDetails() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDitails);
    }

    @And("I place an order")
    public void iPlaceAnOrder() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickPlaceOrder();
    }

    @Then("The order schould be placed successfuly")
    public void AtheOrderSchouldBePlacedSuccessfuly() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.orderPlaceCheck("Thank you. Your order has been received.");
    }



}
