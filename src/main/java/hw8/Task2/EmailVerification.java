package hw8.Task2;

// - логин в Ваш email
// - проверить, что открылась страница со списком писем
// - создать письмо
// - отправить его (можно себе)
// - проверить, что письмо доставлено
// - открыть и прочитать письмо

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EmailVerification {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);


        webDriver.manage().window().maximize();
        webDriver.get("https://www.google.com");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//a[@class=\"gb_g\"]")).click();

        //webDriver.findElement(By.xpath("//a[@href=\"https://accounts.google.com/AccountChooser?service=mail&amp;continue=https://mail.google.com/mail/\"]")).click();
        //webDriver.findElement(By.xpath("//a[@href=\"/checkout/\" and @class=\"top-panel__userbar__cart__item\"]")).click();
        //webDriver.findElement(By.xpath("//a[@href=\"https://accounts.google.com/AccountChooser?service=mail&amp;continue=https://mail.google.com/mail/\" and @class=\"h-c-header__nav-li-link \"]")).click();
        //webDriver.findElement(By.xpath("//ul[contains(@class,\"h-c-header__nav-li-link \"]")).click();
        //webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,\"header__nav--1tr\")]//a[contains(text(),'Войти')]")));
        //WebElement enterBtn = new webDriver.findElement(By.xpath("//ul[contains(@class,\"header__nav--1tr\")]//a[contains(text(),'Войти')]"));

        //enterBtn.click();


    }

}
