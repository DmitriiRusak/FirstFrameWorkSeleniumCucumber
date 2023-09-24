package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    @FindBy(xpath = "//td[@class='product-name']")private WebElement productInTheCart;
    @FindBy(xpath = "//input[@type='number']")private WebElement quantityOfTheProductInTheCart;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")private WebElement checkOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfProduct(){
        return wait.until(ExpectedConditions.visibilityOf(productInTheCart)).getText();
    }

    public int getQuantityOfTheProductInTheCart(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(quantityOfTheProductInTheCart)).
                getAttribute("value"));
    }

    public void checkOutButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();
    }
}
