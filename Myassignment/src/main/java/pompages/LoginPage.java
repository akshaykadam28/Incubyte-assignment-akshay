package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

   
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }

    @FindBy(id = "email")
    private WebElement emailField;

    public void enterEmail(String emailText) {
        emailField.sendKeys(emailText);
    }
    
    @FindBy(id = "pass")
    private WebElement passwordField;

    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    private WebElement signInButtonNew;

    public void clickSignInButtonNew() {
        signInButtonNew.click();
    }

    @FindBy(id = "email-error")
    private WebElement invalidEmailError;

    public boolean isInvalidEmailErrorDisplayed() {
        return invalidEmailError.isDisplayed();
    }

    // Locator for the invalid password error message
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement invalidPasswordError;

    // Method to check if the invalid password error is displayed
    public boolean isInvalidPasswordErrorDisplayed() {
        return invalidPasswordError.isDisplayed();
    }
    
    // Locator for the blank password error message
    @FindBy(id = "pass-error")
    private WebElement blankPasswordError;

    // Method to check if the blank password error is displayed
    public boolean isBlankPasswordErrorDisplayed() {
        return blankPasswordError.isDisplayed();
    }

}