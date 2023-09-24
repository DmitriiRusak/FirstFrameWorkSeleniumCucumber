package cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{

    @FindBy(xpath = "//a[@href='https://askomdch.com/cart/'][@class='added_to_cart wc-forward']") private WebElement cartLink;


    public StorePage(WebDriver driver) {

        super(driver);
    }

    public void addToCart(String nameOfTheProduct){

        WebElement element=driver.findElement(By.xpath("//a[@aria-label='Add “"+nameOfTheProduct+"” to your cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
}
