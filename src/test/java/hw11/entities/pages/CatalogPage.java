package hw11.entities.pages;

public class CatalogPage extends AbstractPage {
    private static String logo = "//h1[@class='catalog-navigation__title']";
    private static String computersNetsBtn = "//*[@id=\"container\"]/div/div/div/div/div[1]/ul/li[3]/span[2]";
    //another localors, if test fails
    //private static String computersNetsBtn = "//li[@data-id='2']";


    public static CatalogPage getCatalogPage() {
        CatalogPage catalogPage = new CatalogPage();
        waitForElementVisible(getElementBy(logo));
        System.out.println("Catalogue page is opened");
        return catalogPage;
    }

    public CatalogFiltersPage clickComputersNetsBtn() {
        getElement(computersNetsBtn).click();
        return CatalogFiltersPage.getCatalogFiltersPage();
    }
}