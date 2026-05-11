package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v145.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class HomePage {
    private final WebDriver driver;

    // ==================== Elements ====================
    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement linkRegister;

    @FindBy(xpath = "//a[normalize-space()='Log In']")
    private WebElement linkLogin;

    @FindBy(className = "caption")
    private WebElement welcomeMessage;

    // ==================== Constructor ====================
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==================== Action Methods ====================
    public void clickRegisterLink() {
        linkRegister.click();
        Log.info("Clicked Register link from Home Page");
    }

    public void clickLoginLink() {
        linkLogin.click();
        Log.info("Clicked Login link from Home Page");
    }

    // ==================== Verification ====================
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
