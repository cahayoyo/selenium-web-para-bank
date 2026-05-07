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
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Elements
    @FindBy(xpath = "//h1[@class='title']")
    WebElement hSigningUpIsEasy;
    @FindBy(xpath = "//p[contains(text(),'If you have an account with us you can sign-up for')]")
    WebElement pIfYouHave;
    @FindBy(xpath = "//b[normalize-space()='First Name:']")
    WebElement labelFirstName;
    @FindBy(xpath = "//b[normalize-space()='Last Name:']")
    WebElement labelLastName;
    @FindBy(xpath = "//b[normalize-space()='Address:']")
    WebElement labelAddress;
    @FindBy(xpath = "//b[normalize-space()='City:']")
    WebElement labelCity;
    @FindBy(xpath = "//b[normalize-space()='State:']")
    WebElement labelState;
    @FindBy(xpath = "//b[normalize-space()='Zip Code:']")
    WebElement labelZipCode;
    @FindBy(xpath = "//b[normalize-space()='Phone #:']")
    WebElement labelPhone;
    @FindBy(xpath = "//b[normalize-space()='SSN:']")
    WebElement labelSSN;
    @FindBy(xpath = "//b[normalize-space()='Username:']")
    WebElement labelUsername;
    @FindBy(xpath = "//b[normalize-space()='Password:']")
    WebElement labelPassword;
    @FindBy(xpath = "//b[normalize-space()='Confirm:']")
    WebElement labelConfirm;
    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement inputFirstName;
    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@id='customer.address.street']")
    WebElement inputAddress;
    @FindBy(xpath = "//input[@id='customer.address.city']")
    WebElement inputCity;
    @FindBy(xpath = "//input[@id='customer.address.state']")
    WebElement inputState;
    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    WebElement inputZipCode;
    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    WebElement inputPhone;
    @FindBy(xpath = "//input[@id='customer.ssn']")
    WebElement inputSSN;
    @FindBy(xpath = "//input[@id='customer.username']")
    WebElement inputUsername;
    @FindBy(xpath = "//input[@id='customer.password']")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@id='repeatedPassword']")
    WebElement inputConfirm;
    @FindBy(xpath = "//input[@value='Register']")
    WebElement buttonRegister;

    public WebElement gethSigningUpIsEasy() { return hSigningUpIsEasy; }
    public WebElement getpIfYouHave() { return pIfYouHave; }
    public WebElement getLabelFirstName() { return labelFirstName; }
    public WebElement getLabelLastName() { return labelLastName; }
    public WebElement getLabelAddress() { return labelAddress; }
    public WebElement getLabelCity() { return labelCity; }
    public WebElement getLabelState() { return labelState; }
    public WebElement getLabelZipCode() { return labelZipCode; }
    public WebElement getLabelPhone() { return labelPhone; }
    public WebElement getLabelSSN() { return labelSSN; }
    public WebElement getLabelUsername() { return labelUsername; }
    public WebElement getLabelPassword() { return labelPassword; }
    public WebElement getLabelConfirm() { return labelConfirm; }
    public WebElement getInputFirstName() { return inputFirstName; }
    public WebElement getInputLastName() { return inputLastName; }
    public WebElement getInputAddress() { return inputAddress; }
    public WebElement getInputCity() { return inputCity; }
    public WebElement getInputState() { return inputState; }
    public WebElement getInputZipCode() { return inputZipCode; }
    public WebElement getInputPhone() { return inputPhone; }
    public WebElement getInputSSN() { return inputSSN; }
    public WebElement getInputUsername() { return inputUsername; }
    public WebElement getInputPassword() { return inputPassword; }
    public WebElement getInputConfirm() { return inputConfirm; }
    public WebElement getButtonRegister() { return buttonRegister; }

    public void clickButtonRegister() { buttonRegister.click(); }

    public void verifyRegisterPageElements(SoftAssert softAssert){
        // ===== Verify URL =====
        Helper.waitUrlContains(driver, Config.URL_REGISTER, 10);
        Helper.verifyContainsUrl(driver, Config.URL_REGISTER, "Register Page");

        // ===== Verify Header & Paragraph
        Helper.verifyElementEqualsText(softAssert, hSigningUpIsEasy, "Signing up is easy!", "Header Signing Up");
        Helper.verifyElementEqualsText(softAssert, pIfYouHave, "If you have an account with us you can sign-up for free instant online access. You will have to provide some personal information.", "Paragraph Below Header");

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
        Helper.verifyElementDisplayed(inputFirstName, "Input First Name");
        Helper.verifyElementEnabled(inputFirstName, "Input First Name");

        Helper.verifyElementDisplayed(inputLastName, "Input Last Name");
        Helper.verifyElementEnabled(inputLastName, "Input Last Name");

        Helper.verifyElementDisplayed(inputAddress, "Input Address");
        Helper.verifyElementEnabled(inputAddress, "Input Address");

        Helper.verifyElementDisplayed(inputCity, "Input City");
        Helper.verifyElementEnabled(inputCity, "Input City");

        Helper.verifyElementDisplayed(inputState, "Input State");
        Helper.verifyElementEnabled(inputState, "Input State");

        Helper.verifyElementDisplayed(inputZipCode, "Input Zip Code");
        Helper.verifyElementEnabled(inputZipCode, "Input Zip Code");

        Helper.verifyElementDisplayed(inputPhone, "Input Phone");
        Helper.verifyElementEnabled(inputPhone, "Input Phone");

        Helper.verifyElementDisplayed(inputSSN, "Input SSN");
        Helper.verifyElementEnabled(inputSSN, "Input SSN");

        Helper.verifyElementDisplayed(inputUsername, "Input Username");
        Helper.verifyElementEnabled(inputUsername, "Input Username");

        Helper.verifyElementDisplayed(inputPassword, "Input Password");
        Helper.verifyElementEnabled(inputPassword, "Input Password");

        Helper.verifyElementDisplayed(inputConfirm, "Input Confirm Password");
        Helper.verifyElementEnabled(inputConfirm, "Input Confirm Password");

        // ==================== Verify Register Button (Displayed + Enabled) ====================
        Helper.verifyElementDisplayed(buttonRegister, "Button Register");
        Helper.verifyElementEnabled(buttonRegister, "Button Register");
        Helper.verifyElementEqualsText(softAssert, buttonRegister, "Register", "Button Register Text");
    }
}
