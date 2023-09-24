package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.utils.ConfigLoader;

import java.time.Duration;
//since we are going to use PageFactory for defining the UI elements we need to initialize those UI elements
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl()+endPoint);
    }

    public WebDriverWait getWait(){
        return wait;
    }
}
