package hw8.OZ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

//1. Открыть oz.by
//2. Зайти в корзину
//3. Проверить, что она пустая
//4. Вернуться назад
//5. В поиске ввести "Программирование"
//6. Открыть первый результат
//7. Добавить его в корзину
//8. Зайти в корзину и проверить, что товар добавился.
public class OzTask1 {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oz.by/");

        WebElement cart = webDriver.findElement(By.xpath("//a[@class=\"top-panel__userbar__cart__item\"]"));
        cart.click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement text1 = webDriver.findElement(By.xpath("//div[contains(text(), \"корзине пусто.\")]"));
        if (text1.isDisplayed()) {
            webDriver.navigate().back();
        }else {
            System.out.println("В корзине что-то есть");
        }

        WebElement searchField = webDriver.findElement(By.xpath("//input[@id=\"top-s\"]"));
        searchField.sendKeys("Программирование");
        searchField.submit();

        List<WebElement> results = webDriver.findElements(By.xpath("//li[@class=\"viewer-type-card__li \"]"));
        results.get(0).click();
        webDriver.findElement(By.xpath("//button[contains(@class, 'addtocart-btn')]")).click();

        (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"/checkout/\" and @class=\"top-panel__userbar__cart__item\"]")));
        webDriver.findElement(By.xpath("//a[@href=\"/checkout/\" and @class=\"top-panel__userbar__cart__item\"]")).click();
        WebElement result = webDriver.findElement(By.xpath("//a[@href=\"https://oz.by/books/more10883310.html\"]"));

        if (result.isDisplayed()) {
            System.out.println("Книга добавлена в корзину.");
        } else {
            System.out.println("Корзина пуста.");
        }
        webDriver.quit();
    }
}