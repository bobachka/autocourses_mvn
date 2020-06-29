package practicalTasks.POExample;

public class LoginPage extends AbstractPage {

    private String loginFld = "mailbox:login";
    private String fillPasswordBtn = "mailbox:submit";
    private String passwordFld = "mailbox:password";

    public void navigateToLoginPage(String url) {
        getDriver().get(url);
    }

    public void fillUsernameFld(String username) {
        getElement(loginFld).sendKeys(username);
    }

    public void clickSubmitPasswordBtn() {
        getElement(fillPasswordBtn).click();
        waitElement(getElement(passwordFld));
    }

    public void fillPasswordFld(String password) {
        getElement(passwordFld).sendKeys(password);
    }
}

/*
а можно через Login page with @FindBy

public class LoginPage {
    private WebDriver driver = DriverUtils.getDriver();

    @FindBy(id = "mailbox:login")
    WebElement loginField;
    @FindBy(id = "mailbox:submit")
    WebElement enterPasswordBtn;
    @FindBy(id = "mailbox:password")
    WebElement passwordField;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage(String url){
        driver.get(url);
    }

    public void fillUsernameFld(String username) {
        loginField.sendKeys(username);
    }

    public void clickEnterPasswordBtn() {
        enterPasswordBtn.click();
        WaitUtils.waitForElement(driver, enterPasswordBtn);
    }

    public void fillPasswordFld(String password) {
        passwordField.sendKeys(password);
    }

    public void close(){
        driver.quit();
    }
}
*/
