package cucumber.runners.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import cucumber.context.TestContext;
import cucumber.factory.DriverFactory;

public class MyHooks {

    private WebDriver classDriverInstanc;
    private final TestContext testContext;

    public MyHooks(TestContext testContext){
        this.testContext=testContext;
    }


    @Before
    public void before(){
        classDriverInstanc=DriverFactory.initDriver(System.getProperty("browser", "fireFox"));
        testContext.driver = classDriverInstanc; // <-- with this statement we are setting our context driver that we want
                                    //to inject in deferent classes

    }

    @After
    public void after() {
        classDriverInstanc.quit();
    }
}
