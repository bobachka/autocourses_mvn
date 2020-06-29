package practicalTasks.POExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractPage {
    private WebDriver driver = DriverUtils.getDriver();

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement(String id) {
        return driver.findElement(By.id(id));
    }

    public void waitElement(WebElement element) {
        WaitUtils.waitForElement(driver, element);
    }
}