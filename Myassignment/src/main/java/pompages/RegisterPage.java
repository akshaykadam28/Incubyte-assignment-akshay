package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

     WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait in the constructor
    }

    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAccountLink;

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//span[contains(text(),'Create an Account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "(//a[normalize-space()='My Orders'])[1]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@id='firstname-error']")
    private WebElement firstNameError;

    @FindBy(xpath = "//div[@id='lastname-error']")
    private WebElement lastNameError;

    @FindBy(xpath = "//div[@id='email_address-error']")
    private WebElement emailError;
    
    @FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement duplicateEmailError;

    @FindBy(xpath = "//div[@id='password-strength-meter']")
    private WebElement passwordStrengthMeter;

    @FindBy(xpath = "//span[@id='password-strength-meter-label']")
    private WebElement weakPassword;

    @FindBy(xpath = "//div[@id='password-confirmation-error']")
    private WebElement confirmPasswordError;


    public void navigateToRegistrationPage() {
        createAccountLink.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void enterFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName != null ? firstName : "");
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName != null ? lastName : "");
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email != null ? email : "");
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password != null ? password : "");
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword != null ? confirmPassword : "");
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isFirstNameErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(firstNameError)).isDisplayed();
    }

    public boolean isLastNameErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(lastNameError)).isDisplayed();
    }

    public boolean isEmailErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailError)).isDisplayed();
    }

    public boolean isDuplicateEmailErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(duplicateEmailError)).isDisplayed();
    }

    public boolean isPasswordStrengthMeterDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(passwordStrengthMeter)).isDisplayed();
    }

    public boolean isWeakPasswordDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(weakPassword)).isDisplayed();
    }

    public boolean isConfirmPasswordErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(confirmPasswordError)).isDisplayed();
    }
}