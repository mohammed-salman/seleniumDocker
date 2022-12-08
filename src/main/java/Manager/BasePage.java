package Manager;

import com.google.inject.Inject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BasePage {

    public static WebDriver driver;
    public static Properties properties;

    public BasePage()
    {
        try
        {
            properties=new Properties();
            FileInputStream fis=new FileInputStream("Config/configuration.properties");
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void initilization() throws InterruptedException, MalformedURLException {
        String browserName=properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.gecko.driver", "Driver/geckodriver");
            driver=new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("safari"))
        {
//            WebDriverManager.safaridriver().setup();
            //System.setProperty("webdriver.gecko.driver", "Driver/geckodriver");
            driver=new SafariDriver();
        }
        else if(browserName.equalsIgnoreCase("remote")) {


            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setBrowserName(BrowserType.CHROME);
            cap.setCapability("browserName","chrome");
            WebDriver driver = new RemoteWebDriver(new URL("http://3.90.190.118:4444/wd/hub"),cap);
            Thread.sleep(5000);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }






}
