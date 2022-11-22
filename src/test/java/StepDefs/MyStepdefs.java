package StepDefs;

import PageObjects.HomePage;
import com.google.inject.Inject;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JacksonInject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {


WebDriver driver;


    @Given("^I Open Google$")
    public void iOpenGoogle() throws InterruptedException {

       new HomePage().Login();
    }

    @And("^Search for something$")
    public void searchForSomething() {
    }
}
