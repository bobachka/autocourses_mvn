package hw11.entities.helpers;

import hw11.entities.pages.CatalogFiltersPage;
import hw11.entities.pages.CatalogPage;

public class CatalogHelper extends AbstractHelper {
    private CatalogPage catalogPage = new CatalogPage();

/*    public CatalogPage getCatalogPage() {
        System.out.println("Go to Catalogue page");
        return catalogPage.getCatalogPage();
    }*/

    public CatalogFiltersPage getCatalogFiltersPage() {
        System.out.println("Go to Filters page");
        catalogPage.clickComputersNetsBtn();
        return new CatalogFiltersPage();
    }
}
