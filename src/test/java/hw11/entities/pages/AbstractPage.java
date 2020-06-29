package hw11.entities.pages;


import hw11.FrameworkCore;
import hw11.core.utils.PauseLength;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage extends FrameworkCore {
    private static WebDriver driver = getInstance();

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void waitForElementVisible(final By by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.MAX.value());
            waiter.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void waitForElementClickable(final String by) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, PauseLength.MAX.value());
            waiter.until(ExpectedConditions.elementToBeClickable(By.id(by)));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static boolean isElementVisible(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(PauseLength.AVG.value(), TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(by);

            if (list.size() == 0) {
                return false;
            } else {
                try {
                    return list.get(0).isDisplayed();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } finally {
            driver.manage().timeouts().implicitlyWait(PauseLength.MAX.value(), TimeUnit.SECONDS);
        }
    }

    public static By getElementBy(String xpath) {
        return By.xpath(xpath);
    }

    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }
}
