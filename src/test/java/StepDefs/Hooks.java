package StepDefs;

import Manager.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class Hooks extends BasePage {



    @Before
    public void setUp() throws MalformedURLException, InterruptedException {

        BasePage.initilization();
        //Setting system properties of ChromeDriver

    }

    @After
    public void tearDown() {


        driver.quit();
    }

}
