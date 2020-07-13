package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {

    private static final String PROJECTS_PAGE_URL = "https://dev.integrivideo.com/app/projects";
    private static final By ADD_PROJECT_BUTTON = By.cssSelector(".project.new");
    private static final By CREATED_PROJECT_D_LOCATOR = By.xpath("//div[text()='Q']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProjectsPage openPage() {
        driver.get(PROJECTS_PAGE_URL);
        return this;
    }

    @Override
    public ProjectsPage isPageOpened() {
        waitForElementVisibility(By.cssSelector(".project.new"));
        return this;
    }

    public void clickAddProjectButton() {
        driver.findElement(ADD_PROJECT_BUTTON).click();
    }
    public void clickOnProject() {
        driver.findElement(CREATED_PROJECT_D_LOCATOR).click();
    }

}
