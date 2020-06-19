package hw8.OZ;

//1. Открыть oz.by
//2. В правом верхнем углу нажать на кнопку "Оплата"
//3. Переключиться на открывшееся окно оплаты
//4. Нажать на кнопку "закрыть это окно".

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class OzTask3 {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oz.by/");

        WebElement paymentBtn = webDriver.findElement(By.xpath("//li[@class=\"top-panel__hnav__li top-panel__hnav__li_r\"]/a[@href=\"javascript:context_help('i.order.payment');\"]"));
        paymentBtn.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Set<String> handles = webDriver.getWindowHandles();
        for (String str : handles) {
            webDriver.switchTo().window(str);
        }

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement closeBtn = webDriver.findElement(By.xpath("//a[@href=\"javascript:window.close();\"]"));
        closeBtn.click();

        webDriver.quit();
    }
}
