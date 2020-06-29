package practicalTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PracticalTask2805 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        Thread.sleep(3000);

        WebElement searchField = webDriver.findElement(By.xpath("//input[@class = \"gLFyf gsfi\"]"));
        searchField.sendKeys("metanit java");
        searchField.submit();
        Thread.sleep(3000);

        List<WebElement> results = webDriver.findElements(By.xpath("//*[@href=\"https://metanit.com/java/tutorial/\"]"));
        results.get(0).click();
        //WebElement results = webDriver.findElement(By.xpath("//*[@href=\"https://metanit.com/java/tutorial/\"]"));
        //results.click();
        Thread.sleep(3000);

        WebElement h1 = webDriver.findElement(By.xpath("//h1[contains(text(), 'Руководство по языку программирования Java')]"));

        if (h1.isDisplayed()) {
            System.out.println("заголовок найден" + h1);
        } else {
            System.out.println("заголовок не найден");
        }

        webDriver.quit();
    }
}