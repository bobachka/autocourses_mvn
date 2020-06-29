package hw11.entities.pages;

public class CatalogFiltersPage extends AbstractPage {
    //another localors, if test fails
    //private static String newWindow = "//div[(@class='catalog-navigation-list__wrapper']";
    //private static String newWindow = "//div[(@class='catalog-navigation-list__aside-title') and contains(text(),'компьютеры')]";
    private static String laptopsComputersBtn = "//div[(@class='catalog-navigation-list__aside-title') and contains(text(),'Ноутбуки')]";
    private static String notebooksBtn = "//a[@href='https://catalog.onliner.by/notebook']";


    public static CatalogFiltersPage getCatalogFiltersPage() {
        CatalogFiltersPage catalogFiltersPage = new CatalogFiltersPage();
        waitForElementVisible(getElementBy(laptopsComputersBtn));
        return catalogFiltersPage;
    }

    public CatalogFiltersPage clickLaptopsComputersBtn() {
        getElement(laptopsComputersBtn).click();
        System.out.println("Filters section is opened");
        return CatalogFiltersPage.getCatalogFiltersPage();
    }

    public NotebookPage clickNotebooksBtn() {
        getElement(notebooksBtn).click();
        return NotebookPage.getNotebookPage();
    }
}
