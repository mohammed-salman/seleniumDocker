package Manager;

import com.google.inject.Inject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public static void initilization()
    {
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

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }






}
