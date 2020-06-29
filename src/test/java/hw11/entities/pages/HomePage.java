package hw11.entities.pages;

public class HomePage extends AbstractPage {
    private static String logo = "//a[@href='https://www.onliner.by/']";
    private static String catalogBtn = "//a[@href='https://catalog.onliner.by/']";

    public static HomePage getHomePage() {
        HomePage homePage = new HomePage();
        waitForElementVisible(getElementBy(logo));
        System.out.println("Home page is opened");
        return homePage;
    }

    public HomePage navigateToHomePage() {
        openUrl(baseUrl);
        return getHomePage();
    }

    public CatalogPage clickCatalogBtn() {
        getElement(catalogBtn).click();
        return CatalogPage.getCatalogPage();
    }
}
