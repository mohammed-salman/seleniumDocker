package PageObjects;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Manager.BasePage;

public class HomePage extends BasePage  {


    @FindBy(xpath = "//input[@value='Google Search'][1]")
    WebElement clickbtn;





    public HomePage() {
        PageFactory.initElements(driver,this);
    }







    public void Login() throws InterruptedException {

        Thread.sleep(3000);
//        WebElement element=(driver.findElement(By.xpath("//input[@value='Google Search'][1]")));
       System.out.println(driver.getTitle());


    }


}
