package cucumber.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import cucumber.domainObjects.BillingDitails;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//input[@id='billing_first_name']")private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='billing_last_name']")private WebElement lastNameInput;
    //@FindBy(xpath = "//select[@id='billing_country']")private WebElement selectContryes;
    @FindBy(xpath = "//span[@id='select2-billing_country-container']")private WebElement selectContryesDropDown;
    @FindBy(xpath = "//input[@id='billing_address_1']")private WebElement addressInput;
    @FindBy(xpath = "//input[@id='billing_city']")private WebElement cityInput;

    //@FindBy(xpath = "//select[@id='billing_state']")private WebElement selectState;
    @FindBy(xpath = "//span[@id='select2-billing_state-container']")private WebElement selectState;

    @FindBy(xpath = "//input[@id='billing_email']")private WebElement emailInput;
    @FindBy(xpath = "//button[@id='place_order']")private WebElement placeOrder;
    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")private WebElement message;
    private boolean buttonIsclicked = false;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirtsName(String bIllingFirtsName){
        WebElement element=wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        element.clear();
        element.sendKeys(bIllingFirtsName);
        return this;
    }

    public CheckoutPage enterLastName(String bIllingLastName){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        element.clear();
        element.sendKeys(bIllingLastName);
        return this;
    }

    public CheckoutPage selectBillingCountryName(String billingContryName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(selectContryesDropDown)).click();
        WebElement nameOfTheCountryToBeEntered = driver.findElement(By.xpath("//li[text()='"+billingContryName+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments [0].scrollIntoView(true);",
                nameOfTheCountryToBeEntered);
        nameOfTheCountryToBeEntered.click();

// this code works well with chrome but not with firefox. It can not handle class Select, but the chrome can.
//        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(selectContryesDropDown)));
//        select.selectByVisibleText(billingContryName);
        return this;
    }

    public CheckoutPage enterAddress(String billingAddress){
        WebElement element=wait.until(ExpectedConditions.visibilityOf(addressInput));
        element.clear();
        element.sendKeys(billingAddress);
        return this;
    }

    public CheckoutPage enterCity(String billingCityInput){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(cityInput));
        element.clear();
        element.sendKeys(billingCityInput);
        return this;
    }

    public CheckoutPage selectState(String billingState) {
        wait.until(ExpectedConditions.elementToBeClickable(selectState)).click();
        WebElement nameOfTheStateToBeEntered = driver.findElement(By.xpath("//li[text()='"+billingState+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments [0].scrollIntoView(true);", nameOfTheStateToBeEntered);
        nameOfTheStateToBeEntered.click();


//        alternative way (not searching for a value in selector but writing value instead and pressing Enter)
//        WebElement element = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
//        element.sendKeys(billingState,Keys.ENTER);
//        Thread.sleep(4000);


//        works only with chrome
//        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(selectState)));
//        select.selectByVisibleText(billingState);
        return this;
    }

    public CheckoutPage enterEmail(String billingEmail){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(emailInput));
        element.clear();
        element.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDitails billingDitails) throws InterruptedException {
        return enterFirtsName(billingDitails.getFirst_name()).
                enterLastName(billingDitails.getLast_name()).
                selectBillingCountryName(billingDitails.getCountry()).
                enterAddress(billingDitails.getStreet_address()).
                enterCity(billingDitails.getTown()).
                selectState(billingDitails.getDepartment()).
                enterEmail(billingDitails.getEmail_address());
//Since every method returning object of this class we can use it again and call next method.
//this is call as builder pattern.

    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOf(placeOrder));
        do {
            try {
                placeOrder.click();
                buttonIsclicked=true;
            } catch (ElementClickInterceptedException | StaleElementReferenceException ignored){
            }
        }while (!buttonIsclicked);
    }

    public void orderPlaceCheck(String expectedResult){
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertEquals(message.getText(),expectedResult,"Somthing wrong with order");


    }
}
