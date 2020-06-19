package hw9.VK;

// Тест должен содержать следующие шаги:
// 1. Залогиниться в vk
// 2. Открыть сообщения
// 3. Отправить сообщение самому себе
// 4. Проверить, что сообщение пришло.
// Использовать аннотацию @Test для тестового метода.
// Тест описать в testng.xml файле и запустить через TestNG командой mvn test.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VKTest {

    private WebDriver driver = new ChromeDriver();
    private static String EMAIL;
    private static String PASSWORD;
    private static String USERNAME;
    private static String testMessage = "test msg for myself";

    @BeforeClass
    public void setUpData() {
        EMAIL = "test@tut.by";
        PASSWORD = "test";
        USERNAME = "name surname";
    }

    @Test
    public void LoginTest() {
        driver.manage().window().maximize();
        driver.get("https://vk.com/");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("index_email")));

        WebElement emailFld = driver.findElement(By.id("index_email"));
        WebElement passwordFld = driver.findElement(By.id("index_pass"));
        WebElement loginBtn = driver.findElement(By.id("index_login_button"));

        emailFld.sendKeys(EMAIL);
        passwordFld.sendKeys(PASSWORD);
        loginBtn.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("l_msg")));
        WebElement messages = driver.findElement(By.id("l_msg"));
        messages.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("im_dialogs_search")));
        WebElement searchFld = driver.findElement(By.id("im_dialogs_search"));
        searchFld.sendKeys(USERNAME);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"im_dialogs\"]/li[3]")));
        WebElement result = driver.findElement(By.xpath("//*[@id=\"im_dialogs\"]/li[3]"));
        result.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("im_editable0")));
        WebElement textFld = driver.findElement(By.id("im_editable0"));
        WebElement sendBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[3]/div[2]/div[4]/div[2]/div[4]/div[1]/button"));
        //WebElement sendBtn = driver.findElement(By.className("im-send-btn im-chat-input--send _im_send im-send-btn_send"));
        //это работает, но почему-то падает ошибка
        textFld.sendKeys(testMessage);
        sendBtn.click();

        String msgXpath = "//*[@id=\"content\"]//div[contains(text(), \"" + testMessage + "\")]";


        if (driver.findElement(By.xpath(msgXpath)).isDisplayed()) {
            System.out.println("The message " + testMessage + " is sent successfully");
        } else System.out.println("The message is not found");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
