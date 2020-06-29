package practicalTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstTestClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        Thread.sleep(3000);

        WebElement searchField = webDriver.findElement(By.xpath("//input[@class = \"gLFyf gsfi\"]"));
        searchField.sendKeys("Selenium Webdriver");
        searchField.submit();

        Thread.sleep(3000);

        List<WebElement> results = webDriver.findElements(By.xpath("//div[@id = 'rso']/div"));
        System.out.println("Found results " + results.size());
        assert (results.size() > 0);

        webDriver.quit();
    }
}
