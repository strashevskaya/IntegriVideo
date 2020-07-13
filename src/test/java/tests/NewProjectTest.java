package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class NewProjectTest extends BaseTest {

    @Test
    @Description("Creating new project")
    public void createProject(){
        loginPage
                .openPage()
                .isPageOpened()
                .login("kristina@mailinator.com", "password123");
        projectsPage
                .openPage()
                .isPageOpened()
                .clickAddProjectButton();
        newProjectPage
                .openPage()
                .isPageOpened()
                .addNewProject("AQA6", "courses", "tms.com");

    }

    @Test
    @Description("Adding more projects")
    public void addedNewProject() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("kristina@mailinator.com", "password123");
        projectsPage
                .openPage()
                .isPageOpened()
                .clickAddProjectButton();
        newProjectPage
                .openPage()
                .isPageOpened()
                .addNewProject("AQA6", "courses", "tms.com")
                .verifyNumberOfCreatedProjects(4);
    }

    @Test
    @Description("Verification: new project is displayed on page 'Projects'")
    public void newProject() {
        loginPage
                .openPage()
                .isPageOpened()
                 .login("kristina@mailinator.com", "password123");
        projectsPage
                .openPage()
                .isPageOpened()
                .clickAddProjectButton();
        newProjectPage
                .openPage()
                .isPageOpened()
                .addNewProject("DQA7", "courses", "tms.com")
                .verifyProjectCreated("D");
            }
    @Test
    @Description("Verification of project name is changed successfully")
    public void improvedProject() {
        loginPage
                .openPage()
                .isPageOpened()
                .login("kristina@mailinator.com", "password123");
        projectsPage
                .clickOnProject();
        projectDetailsPage
                .clickEditButton();
        newProjectPage
                .refactorProjectName("WE");

    }



}
