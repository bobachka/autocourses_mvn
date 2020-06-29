package practicalTasks.cucumber;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDef {
    private String today;
    private String actAnswer;

    @Given("Today is Sun")
    public void today_is_Sun() {
        today = "Sunday";
    }

    @When("I ask if it's Fri today")
    public void I_ask_if_it_s_Fri() {
        actAnswer = IsItFri.isItFri(today);
    }

    @Then("It says {string}")
    public void it_says(String expAnswer) {
        Assert.assertEquals(expAnswer, actAnswer);
    }
}
