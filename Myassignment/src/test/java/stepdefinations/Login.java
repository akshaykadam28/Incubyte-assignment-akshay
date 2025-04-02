package stepdefinations;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pompages.LoginPage;
import factory.DriverFactory;
import java.time.Duration;

public class Login {

    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    // Initialize WebDriver and WebDriverWait
    public Login() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    @Given("the user is on the sign in page")
    public void the_user_is_on_the_sign_in_page() {
        driver.get("https://magento.softwaretestingboard.com/"); 
        loginPage.clickSignInButton(); // Clicks on the Sign In button if not already on the login page
    }

    @When("the user enters a valid email {string}")
    public void the_user_enters_a_valid_email(String email) {
        loginPage.enterEmail(email);
    }

    @And("a valid password {string}")
    public void a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("clicks on {string}")
    public void clicks_on(String buttonText) {
        loginPage.clickSignInButtonNew(); 
    }

    @Then("the user should be successfully signed in and redirected to the dashboard")
    public void the_user_should_be_successfully_signed_in_and_redirected_to_the_dashboard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Akshay Kadam!']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Akshay Kadam!']")).isDisplayed());
    }

    @When("the user enters an invalid email format {string}")
    public void the_user_enters_an_invalid_email_format(String invalidEmail) {
        loginPage.enterEmail(invalidEmail);
    }

    @Then("an error message should be displayed indicating that the email format is invalid")
    public void an_error_message_should_be_displayed_indicating_that_the_email_format_is_invalid() {
        Assert.assertTrue(loginPage.isInvalidEmailErrorDisplayed());
    }

    @When("an incorrect password {string}")
    public void an_incorrect_password(String invalidPassword) {
        loginPage.enterPassword(invalidPassword);
    }

    @Then("an error message should be displayed indicating that the email or password is incorrect")
    public void an_error_message_should_be_displayed_indicating_that_the_email_or_password_is_incorrect() {
        Assert.assertTrue(loginPage.isInvalidPasswordErrorDisplayed());
    }

    @When("the user leaves the email field blank")
    public void the_user_leaves_the_email_field_blank() {
        loginPage.enterEmail("");
    }

    @When("enters a valid password {string}")
    public void enters_a_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @Then("an error message should be displayed indicating that the email is required")
    public void an_error_message_should_be_displayed_indicating_that_the_email_is_required() {
        Assert.assertTrue(loginPage.isInvalidEmailErrorDisplayed());
    }

    @When("leaves the password field blank")
    public void leaves_the_password_field_blank() {
        loginPage.enterPassword("");
    }

    @Then("an error message should be displayed indicating that the password is required")
    public void an_error_message_should_be_displayed_indicating_that_the_password_is_required() {
        Assert.assertTrue(loginPage.isBlankPasswordErrorDisplayed());
    }

    @When("the user leaves both email and password fields blank")
    public void the_user_leaves_both_email_and_password_fields_blank() {
        loginPage.enterEmail("");
        loginPage.enterPassword("");
    }

    @Then("error messages should be displayed for both fields indicating that they are required")
    public void error_messages_should_be_displayed_for_both_fields_indicating_that_they_are_required() {
        Assert.assertTrue(loginPage.isInvalidEmailErrorDisplayed());
        Assert.assertTrue(loginPage.isBlankPasswordErrorDisplayed());
    }

    @When("the user enters an unregistered email {string} and a valid password {string}")
    public void the_user_enters_an_unregistered_email_and_a_valid_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

}