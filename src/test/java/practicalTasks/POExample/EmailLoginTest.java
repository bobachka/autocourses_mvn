package practicalTasks.POExample;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailLoginTest {
    private static final String USERNAME = "someuser";
    private static final String PASSWORD = "somepass";

    private LoginPage loginPage;

    @BeforeClass
    public void before() {
        loginPage = new LoginPage();
        loginPage.navigateToLoginPage("https://mail.ru/");
    }

    @Test
    public void login() {
        loginPage.fillUsernameFld(USERNAME);
        loginPage.clickSubmitPasswordBtn();
        loginPage.fillPasswordFld(PASSWORD);
    }

    @AfterClass
    public void tearDown() {
        loginPage.getDriver().quit();
    }
}