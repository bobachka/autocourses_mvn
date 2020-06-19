package hw8.OZ;

//1. Открыть oz.by
//2. Проверить, что слева отображаются все фильтры (Продукты и деликатесы … Здоровье, медтехника).
//3. Для хранения имен фильтров завести коллекцию (expectedResults)
//4. Названия фильтров собрать в коллекцию (actualResults)
//5. Сравнить две коллекции.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OzTask2 {
    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://oz.by");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("Продукты, деликатесы");
        expectedResults.add("Книги");
        expectedResults.add("Косметика, парфюмерия");
        expectedResults.add("Дом, сад, зоотовары");
        expectedResults.add("Развлечения, творчество");
        expectedResults.add("Канцтовары, учёба");
        expectedResults.add("Сувениры, подарки");
        expectedResults.add("Детям и мамам");
        expectedResults.add("Туризм, отдых, спорт");
        expectedResults.add("Техника, электроника");
        expectedResults.add("Здоровье, медтехника");

        ArrayList<String> actualResults = new ArrayList<>();
        List<WebElement> elements = webDriver.findElements(By.xpath("//a[@class=\"menu-link-action main-nav__list__item \"]"));
        for (int i = 0; i < elements.size(); i++) {
            actualResults.add(elements.get(i).getText());
        }
        if (expectedResults.containsAll(actualResults) && expectedResults.size() == actualResults.size()) {
            System.out.println("Фильтры верны");
        } else {
            System.out.println("С фильтрами что-то не так");
        }
        webDriver.quit();
    }
}