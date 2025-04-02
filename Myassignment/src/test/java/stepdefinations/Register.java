package stepdefinations;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pompages.RegisterPage;

public class Register {

    private WebDriver driver;
    private RegisterPage registerPage;

    @Given("User is on the registration page")
    public void user_is_on_the_registration_page() {
        driver = DriverFactory.getDriver();
        registerPage = new RegisterPage(driver);
        registerPage.navigateToRegistrationPage();
    }

    @When("User enters the following registration details:")
    public void user_enters_the_following_registration_details(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage.enterFirstName(dataMap.get("First Name"));
        registerPage.enterLastName(dataMap.get("Last Name"));
        registerPage.enterEmail(dataMap.get("Email"));
        registerPage.enterPassword(dataMap.get("Password"));
        registerPage.enterConfirmPassword(dataMap.get("Confirm Password"));
    }

    @And("User clicks on {string}")
    public void user_clicks_on(String buttonText) {
        registerPage.clickCreateAccountButton();
    }

    @Then("User should be successfully registered and redirected to the dashboard")
    public void user_should_be_successfully_registered_and_redirected_to_the_dashboard() {
        Assert.assertTrue("Success message is not displayed or incorrect.", 
            registerPage.getSuccessMessage().contains("My Orders"));
    }

    @When("User leaves the First Name field blank")
    public void user_leaves_the_first_name_field_blank() {
        registerPage.enterFirstName(""); 
    }

    @And("User enters the following details:")
    public void user_enters_the_following_details(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage.enterLastName(dataMap.get("Last Name"));
        registerPage.enterEmail(dataMap.get("Email"));
        registerPage.enterPassword(dataMap.get("Password"));
        registerPage.enterConfirmPassword(dataMap.get("Confirm Password"));
    }

    @Then("User should see an error message indicating that First Name is required")
    public void user_should_see_an_error_message_indicating_that_first_name_is_required() {
        Assert.assertTrue("First Name error message is not displayed.", 
            registerPage.isFirstNameErrorDisplayed());
    }

    @When("User leaves the Last Name field blank")
    public void user_leaves_the_last_name_field_blank() {
        registerPage.enterLastName(""); 
    }

    @Then("User should see an error message indicating that Last Name is required")
    public void user_should_see_an_error_message_indicating_that_last_name_is_required() {
        Assert.assertTrue("Last Name error message is not displayed.", 
            registerPage.isLastNameErrorDisplayed());
    }

    @Then("User should see an error message indicating that Email is invalid")
    public void user_should_see_an_error_message_indicating_that_email_is_invalid() {
        Assert.assertTrue("Invalid Email error message is not displayed.", 
            registerPage.isEmailErrorDisplayed());
    }

    @Then("User should see an error message indicating that the Password is too weak")
    public void user_should_see_an_error_message_indicating_that_the_password_is_too_weak() {
        Assert.assertTrue("Weak Password error message is not displayed.", 
            registerPage.isWeakPasswordDisplayed());
    }

    @Then("User should see an error message indicating that Password and Confirm Password do not match")
    public void user_should_see_an_error_message_indicating_that_password_and_confirm_password_do_not_match() {
        Assert.assertTrue("Password mismatch error message is not displayed.", 
            registerPage.isConfirmPasswordErrorDisplayed());
    }

    @When("User leaves the Password field blank")
    public void user_leaves_the_password_field_blank() {
        registerPage.enterPassword(""); 
    }

    @When("User leaves the Confirm Password field blank")
    public void user_leaves_the_confirm_password_field_blank() {
        registerPage.enterConfirmPassword(""); 
    }

    @Then("User should see an error message indicating that Password is required")
    public void user_should_see_an_error_message_indicating_that_password_is_required() {
        Assert.assertTrue("Password required error message is not displayed.", 
            registerPage.isPasswordStrengthMeterDisplayed());
    }

    @Then("User should see an error message indicating that Confirm Password is required")
    public void user_should_see_an_error_message_indicating_that_confirm_password_is_required() {
        Assert.assertTrue("Confirm Password required error message is not displayed.", 
            registerPage.isConfirmPasswordErrorDisplayed());
    }

    @Then("User should see an error message indicating that Email is already in use")
    public void user_should_see_an_error_message_indicating_that_email_is_already_in_use() {
        //Assert.assertTrue("Email already in use error message is not displayed.", 
          //  registerPage.isDuplicateEmailErrorDisplayed());
    }

    @Then("User should see an error message indicating that Email is required")
    public void user_should_see_an_error_message_indicating_that_email_is_required() {
        Assert.assertTrue("Email required error message is not displayed.", 
            registerPage.isEmailErrorDisplayed());
    }

    @When("User leaves all fields \\(First Name, Last Name, Email, Password, Confirm Password) blank")
    public void user_leaves_all_fields_first_name_last_name_email_password_confirm_password_blank() {
        registerPage.enterFirstName("");
        registerPage.enterLastName("");
        registerPage.enterEmail("");
        registerPage.enterPassword("");
        registerPage.enterConfirmPassword("");
    }

    @Then("User should see error messages for all required fields indicating that they must be filled out before proceeding")
    public void user_should_see_error_messages_for_all_required_fields_indicating_that_they_must_be_filled_out_before_proceeding() {
        Assert.assertTrue("First Name error message is not displayed.", 
            registerPage.isFirstNameErrorDisplayed());
        Assert.assertTrue("Last Name error message is not displayed.", 
            registerPage.isLastNameErrorDisplayed());
        Assert.assertTrue("Email error message is not displayed.", 
            registerPage.isEmailErrorDisplayed());
        Assert.assertTrue("Password error message is not displayed.", 
            registerPage.isPasswordStrengthMeterDisplayed());
        Assert.assertTrue("Confirm Password error message is not displayed.", 
            registerPage.isConfirmPasswordErrorDisplayed());
    }
}