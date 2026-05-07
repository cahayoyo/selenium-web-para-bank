package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utils.Config;
import utils.Helper;
import utils.Log;

public class RegisterPage {
    private final WebDriver driver;

    // ==================== Elements ====================
    @FindBy(xpath = "//h1[@class='title']")
    private WebElement headerSigningUp;

    @FindBy(xpath = "//p[contains(text(),'If you have an account with us you can sign-up for')]")
    private WebElement paragraphDescription;

    @FindBy(xpath = "//b[normalize-space()='First Name:']") private WebElement labelFirstName;
    @FindBy(xpath = "//b[normalize-space()='Last Name:']") private WebElement labelLastName;
    @FindBy(xpath = "//b[normalize-space()='Address:']") private WebElement labelAddress;
    @FindBy(xpath = "//b[normalize-space()='City:']") private WebElement labelCity;
    @FindBy(xpath = "//b[normalize-space()='State:']") private WebElement labelState;
    @FindBy(xpath = "//b[normalize-space()='Zip Code:']") private WebElement labelZipCode;
    @FindBy(xpath = "//b[normalize-space()='Phone #:']") private WebElement labelPhone;
    @FindBy(xpath = "//b[normalize-space()='SSN:']") private WebElement labelSSN;
    @FindBy(xpath = "//b[normalize-space()='Username:']") private WebElement labelUsername;
    @FindBy(xpath = "//b[normalize-space()='Password:']") private WebElement labelPassword;
    @FindBy(xpath = "//b[normalize-space()='Confirm:']") private WebElement labelConfirm;

    @FindBy(xpath = "//input[@id='customer.firstName']") private WebElement txtFirstName;
    @FindBy(xpath = "//input[@id='customer.lastName']") private WebElement txtLastName;
    @FindBy(xpath = "//input[@id='customer.address.street']") private WebElement txtAddress;
    @FindBy(xpath = "//input[@id='customer.address.city']") private WebElement txtCity;
    @FindBy(xpath = "//input[@id='customer.address.state']") private WebElement txtState;
    @FindBy(xpath = "//input[@id='customer.address.zipCode']") private WebElement txtZipCode;
    @FindBy(xpath = "//input[@id='customer.phoneNumber']") private WebElement txtPhone;
    @FindBy(xpath = "//input[@id='customer.ssn']") private WebElement txtSSN;
    @FindBy(xpath = "//input[@id='customer.username']") private WebElement txtUsername;
    @FindBy(xpath = "//input[@id='customer.password']") private WebElement txtPassword;
    @FindBy(xpath = "//input[@id='repeatedPassword']") private WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@value='Register']") private WebElement btnRegister;

    // ==================== Constructor ====================
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==================== Action Methods ====================
    public void enterFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void enterAddress(String address) {
        txtAddress.sendKeys(address);
    }

    public void enterCity(String city) {
        txtCity.sendKeys(city);
    }

    public void enterState(String state) {
        txtState.sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        txtZipCode.sendKeys(zipCode);
    }

    public void enterPhone(String phone) {
        txtPhone.sendKeys(phone);
    }

    public void enterSSN(String ssn) {
        txtSSN.sendKeys(ssn);
    }

    public void enterUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        txtConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        btnRegister.click();
    }

    public boolean isHeaderDisplayed() {
        return headerSigningUp.isDisplayed();
    }

    public void clearAllFields() {
        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        txtCity.clear();
        txtState.clear();
        txtZipCode.clear();
        txtPhone.clear();
        txtSSN.clear();
        txtUsername.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
    }

    public void verifyRegisterPageElements(SoftAssert softAssert){
        // ===== Verify URL =====
        Helper.waitUrlContains(driver, Config.URL_REGISTER, 10);
        Helper.verifyContainsUrl(driver, Config.URL_REGISTER, "Register Page");

        // ===== Verify Header & Paragraph
        Helper.verifyElementEqualsText(softAssert, headerSigningUp, "Signing up is easy!", "Header Signing Up");
        Helper.verifyElementEqualsText(softAssert, paragraphDescription, "If you have an account with us you can sign-up for free instant online access. You will have to provide some personal information.", "Paragraph Below Header");

        // ===== Verify All Labels =====
        Helper.verifyElementEqualsText(softAssert, labelFirstName, "First Name:", "Label First Name");
        Helper.verifyElementEqualsText(softAssert, labelLastName, "Last Name:", "Label Last Name");
        Helper.verifyElementEqualsText(softAssert, labelAddress, "Address:", "Label Address");
        Helper.verifyElementEqualsText(softAssert, labelCity, "City:", "Label City");
        Helper.verifyElementEqualsText(softAssert, labelState, "State:", "Label State");
        Helper.verifyElementEqualsText(softAssert, labelZipCode, "Zip Code:", "Label Zip Code");
        Helper.verifyElementEqualsText(softAssert, labelPhone, "Phone #:", "Label Phone");
        Helper.verifyElementEqualsText(softAssert, labelSSN, "SSN:", "Label SSN");
        Helper.verifyElementEqualsText(softAssert, labelUsername, "Username:", "Label Username");
        Helper.verifyElementEqualsText(softAssert, labelPassword, "Password:", "Label Password");
        Helper.verifyElementEqualsText(softAssert, labelConfirm, "Confirm:", "Label Confirm");

        // ==================== Verify All Input Fields (Displayed + Enabled) ====================
        Helper.verifyElementDisplayed(txtFirstName, "Input First Name");
        Helper.verifyElementEnabled(txtFirstName, "Input First Name");

        Helper.verifyElementDisplayed(txtLastName, "Input Last Name");
        Helper.verifyElementEnabled(txtLastName, "Input Last Name");

        Helper.verifyElementDisplayed(txtAddress, "Input Address");
        Helper.verifyElementEnabled(txtAddress, "Input Address");

        Helper.verifyElementDisplayed(txtCity, "Input City");
        Helper.verifyElementEnabled(txtCity, "Input City");

        Helper.verifyElementDisplayed(txtState, "Input State");
        Helper.verifyElementEnabled(txtState, "Input State");

        Helper.verifyElementDisplayed(txtZipCode, "Input Zip Code");
        Helper.verifyElementEnabled(txtZipCode, "Input Zip Code");

        Helper.verifyElementDisplayed(txtPhone, "Input Phone");
        Helper.verifyElementEnabled(txtPhone, "Input Phone");

        Helper.verifyElementDisplayed(txtSSN, "Input SSN");
        Helper.verifyElementEnabled(txtSSN, "Input SSN");

        Helper.verifyElementDisplayed(txtUsername, "Input Username");
        Helper.verifyElementEnabled(txtUsername, "Input Username");

        Helper.verifyElementDisplayed(txtPassword, "Input Password");
        Helper.verifyElementEnabled(txtPassword, "Input Password");

        Helper.verifyElementDisplayed(txtConfirmPassword, "Input Confirm Password");
        Helper.verifyElementEnabled(txtConfirmPassword, "Input Confirm Password");

        // ==================== Verify Register Button (Displayed + Enabled) ====================
        Helper.verifyElementDisplayed(btnRegister, "Button Register");
        Helper.verifyElementEnabled(btnRegister, "Button Register");
        Helper.verifyElementEqualsText(softAssert, btnRegister, "Register", "Button Register Text");
    }

    public void registerNewUser(String firstName, String lastName, String address, String city,
                                String state, String zipCode, String phone, String ssn,
                                String username, String password) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        enterZipCode(zipCode);
        enterPhone(phone);
        enterSSN(ssn);
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(password);

        Log.info("Submitted registration form with username: " + username);
    }
}
