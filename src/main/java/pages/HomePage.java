package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v145.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    }

    public void clickLoginLink() {
        linkLogin.click();
    }

    // ==================== Verification ====================
    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
