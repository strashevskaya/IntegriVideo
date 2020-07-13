package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static final String URL = "https://dev.integrivideo.com/login";

    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = ".btn.btn-primary")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage openPage() {
        driver.get(URL);
        PageFactory.initElements(driver, this);
        isPageOpened();
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        waitForElementVisibility(By.cssSelector(".btn.btn-primary"));
        return this;
    }

    public LoginPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }


    public ProjectsPage verifyLoginSuccess() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".project.new")));
        return new ProjectsPage(driver);
    }

    public LoginPage verifyErrorMessageIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[role='alert']"))));
        return this;
    }


}