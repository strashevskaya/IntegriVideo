package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewProjectPage extends BasePage {

    private static final String NEW_PROJECT_URL = "https://dev.integrivideo.com/app/projects/new";
    private static final By PROJECT_NAME_INPUT = By.cssSelector("[name='name']");
    private static final By DESCRIPTION_INPUT = By.cssSelector("[placeholder='Type here...']");
    private static final By DOMAINS_INPUT = By.cssSelector("[name='domains[]']");
    private static final By CREATE_BUTTON = By.xpath("//div//button[text()='Create']");
    private static final By PROJECT_LOCATOR = By.xpath("//span[contains(text(),'active')]");
    private static final By CREATED_PROJECT_LOCATOR = By.xpath("//div[text()='D']");
    private static final By PROJECT_D_NAME_INPUT = By.cssSelector("[value='QA']");
    private static final By UPDATE_BUTTON = By.xpath("//div//button[text()='Update']");

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public NewProjectPage openPage() {
        driver.get(NEW_PROJECT_URL);
        return this;
    }

    @Override
    public NewProjectPage isPageOpened() {
        waitForElementVisibility(By.xpath("//div//button[text()='Create']"));
        return this;
    }

    public NewProjectPage addNewProject(String projectName, String description, String domains) {
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(projectName);
        driver.findElement(DESCRIPTION_INPUT).sendKeys(description);
        driver.findElement(DOMAINS_INPUT).sendKeys(domains);
        driver.findElement(CREATE_BUTTON).click();
        return this;
    }

    public void verifyNumberOfCreatedProjects(int number) {
        Assert.assertEquals(driver.findElements(PROJECT_LOCATOR).size(),number,"Quantity isn't correct");
    }

    public void verifyProjectCreated(String text) {
        Assert.assertEquals(driver.findElement(CREATED_PROJECT_LOCATOR), text, "Project isn't created");
    }


    public void refactorProjectName(String nameInput) {
        driver.findElement(PROJECT_D_NAME_INPUT).clear();
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(nameInput);
        driver.findElement(UPDATE_BUTTON).click();
    }

}
