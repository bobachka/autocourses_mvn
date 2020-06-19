package hw10;

//1. Открываем oz.by
//2. Проверяем, что элементы отображаются на странице:
//   - поле поиска
//   - кнопки Войти и Корзина
//   - фильтры слева
//3. Тест реализовать через Page Object паттерн

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OzPage {
    private WebDriver driver = DriverUtils.getDriver();

    // @FindBy(xpath = "//input[@id=\"top-s\"]")
    @FindBy(id = "top-s")
    WebElement searchFld;

    @FindBy(className = "top-panel__userbar__auth")
    WebElement loginBtn;

    // @FindBy(xpath = "//a[@class=\"top-panel__userbar__cart__item\"]")
    @FindBy(xpath = "//a[@href=\"/checkout/\"]")
    WebElement shoppingCartBtn;

    @FindBy(xpath = "//li[@class=\"main-nav__list__li main-nav__list__li_wnav\"]")
    WebElement filters;

    public OzPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToOz(String url) {
        driver.get(url);
    }

    public void verifySearchFldPresence() {
        WaitUtils.waitForElement(driver, searchFld);
        if (searchFld.isDisplayed()) {
            System.out.println("Search field is present");
        }
    }

    public boolean verifyLoginBtnPresence() {
        if (loginBtn.isDisplayed()) {
            System.out.println("Login button is present");
        }
        return loginBtn.isDisplayed();
    }

    public void verifyShoppingCartBtnPresence() {
        WaitUtils.waitForElement(driver, shoppingCartBtn);
        if (shoppingCartBtn.isDisplayed()) {
            System.out.println("Shopping Cart button field is present");
        }
    }

    public boolean verifyFiltersPresence() {
        if (filters.isDisplayed()) {
            System.out.println("List of filters is present");
        }
        return filters.isDisplayed();
    }

    //этот метод для практики с множественными условиями
    public boolean verifyAllElements() {
        System.out.println("\nEverything is fine");
        return searchFld.isDisplayed() && loginBtn.isDisplayed() && shoppingCartBtn.isDisplayed() && filters.isDisplayed();
    }

    public void closeWindow() {
        driver.quit();
    }
}
