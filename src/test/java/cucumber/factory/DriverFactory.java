package cucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    public static WebDriver initDriver(String driverName){
        WebDriver driver;
        switch (driverName) {
            case "fireFox" -> {
                //System.setProperty("webdriver.geckodriver.driver", "C:\\Program Files\\WEB_DRIVERS\\Firefox\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> {
//                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WEB_DRIVERS\\Chrome\\chromedriver.exe");
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

}
