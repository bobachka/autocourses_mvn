package hw11.entities.helpers;

import hw11.entities.pages.HomePage;

public class HomeHelper extends AbstractHelper {

    private HomePage homePage = new HomePage();

    public HomeHelper navigateToHomePage() {
        System.out.println("Go to home page");
        homePage.navigateToHomePage();
        return this;
    }

    public CatalogHelper navigateToCatalogPage() {
        System.out.println("Go to Catalogue page");
        homePage.clickCatalogBtn();
        return new CatalogHelper();
    }
}
