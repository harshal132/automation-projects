package tests;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


public class SampleDefinition extends AbstractTestNGCucumberTests {
	
	@Given("Import dependency")
	public void import_dependency() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 1");
		System.out.println("Import dependency");
	}

	@And("Run gherkin file")
	public void run_gherkin_file() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 2");
		System.out.println("Run gherkin file");
	}

	@Then("Update Java file")
	public void update_java_file() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 3");
		System.out.println("Update Java file");
	}

	@Then("Save changes")
	public void save_changes() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("Step 4");
		System.out.println("Save changes");
	}

}
