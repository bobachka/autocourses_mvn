package hw11.tests;

import hw11.entities.helpers.CatalogFiltersHelper;
import hw11.entities.helpers.CatalogHelper;
import hw11.entities.helpers.HomeHelper;
import hw11.entities.helpers.NotebookHelper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class OnlinerSearchTest {
    private HomeHelper homeHelper = new HomeHelper();
    private CatalogHelper catalogHelper = new CatalogHelper();
    private CatalogFiltersHelper catalogFiltersHelper = new CatalogFiltersHelper();
    private NotebookHelper notebookHelper = new NotebookHelper();

    @Test
    public void performSearch() throws InterruptedException {
        System.out.println("We're about to start! Mind the gap!\n");
        homeHelper.navigateToHomePage();
        homeHelper.navigateToCatalogPage();
        catalogHelper.getCatalogFiltersPage();
        catalogFiltersHelper.clickLaptopsComputersBtn();
        catalogFiltersHelper.clickNotebooksBtn();
        notebookHelper.setFilters();
        int resultsCount = notebookHelper.getSearchResults();
        Assert.assertTrue(resultsCount > 0, "Nothing is found. Plz take a look.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Quiting the browser.");
        homeHelper.quit();
    }
}
