package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.Helper;
import utils.Log;

public class LoginPage {
    private final WebDriver driver;

    // ==================== Elements ====================

    @FindBy(xpath = "//h2[text()='Customer Login']")
    private WebElement headerCustomerLogin;

    @FindBy(xpath = "//p[contains(text(),'Please enter your username and password')]")
    private WebElement paragraphInstruction;

    @FindBy(xpath = "//b[normalize-space()='Username:']")
    private WebElement labelUsername;

    @FindBy(xpath = "//b[normalize-space()='Password:']")
    private WebElement labelPassword;

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement linkRegister;

    // ==================== Constructor ====================
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==================== Action Methods ====================
    public void enterUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        btnLogin.click();
        Log.info("Clicked Login button");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        Log.info("Submitted login form with username: " + username);
    }

    public void clearFields() {
        txtUsername.clear();
        txtPassword.clear();
    }

    public WebElement getUsernameField() {
        return txtUsername;
    }

    public WebElement getPasswordField() {
        return txtPassword;
    }

    // ==================== Verification ====================

    public boolean isHeaderDisplayed() {
        return headerCustomerLogin.isDisplayed();
    }

    public boolean isLoginFormDisplayed() {
        try {
            return txtUsername.isDisplayed() &&
                    txtPassword.isDisplayed() &&
                    btnLogin.isDisplayed();
        } catch (Exception e) {
            Log.error("Login form elements not found: " + e.getMessage());
            return false;
        }
    }

    public void verifyLoginPageElements(SoftAssert softAssert) {
        Helper.verifyElementEqualsText(softAssert, headerCustomerLogin, "Customer Login", "Header Customer Login");
        Helper.verifyElementEqualsText(softAssert, paragraphInstruction,
                "Please enter your username and password.", "Instruction Paragraph");

        Helper.verifyElementEqualsText(softAssert, labelUsername, "Username:", "Label Username");
        Helper.verifyElementEqualsText(softAssert, labelPassword, "Password:", "Label Password");

        Helper.verifyElementDisplayed(txtUsername, "Input Username");
        Helper.verifyElementEnabled(txtUsername, "Input Username");

        Helper.verifyElementDisplayed(txtPassword, "Input Password");
        Helper.verifyElementEnabled(txtPassword, "Input Password");

        Helper.verifyElementDisplayed(btnLogin, "Button Login");
        Helper.verifyElementEnabled(btnLogin, "Button Login");
        Helper.verifyElementEqualsText(softAssert, btnLogin, "Log In", "Button Login Text");
    }
}
