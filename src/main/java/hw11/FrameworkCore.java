package hw11;

import hw11.core.utils.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkCore {
    private static WebDriver driver;

    public static String browser = IOUtils.loadGenericProperty("browser", "configuration");
    public static String baseUrl = IOUtils.loadGenericProperty("onlinerBaseUrl", "configuration");

    public static WebDriver getInstance() {
        driver = new ChromeDriver();
        return driver;
    }
}
