package hw11.entities.helpers;

import hw11.entities.pages.CatalogFiltersPage;
import hw11.entities.pages.NotebookPage;

public class CatalogFiltersHelper  extends AbstractHelper{
    private CatalogFiltersPage catalogFiltersPage = new CatalogFiltersPage();

/*    public CatalogFiltersPage getCatalogFiltersPage() {
        return catalogFiltersPage.getCatalogFiltersPage();
    }*/

    public CatalogFiltersPage clickLaptopsComputersBtn() {
        //return catalogFiltersPage.clickLaptopsComputersBtn();
        catalogFiltersPage.clickLaptopsComputersBtn();
        return new CatalogFiltersPage();
    }

    public NotebookPage clickNotebooksBtn() {
        System.out.println("Go to Notebook page");
        //return catalogFiltersPage.clickNotebooksBtn();
        catalogFiltersPage.clickNotebooksBtn();
        return new NotebookPage();
    }
}
