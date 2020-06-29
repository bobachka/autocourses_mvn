package hw11.entities.pages;

public class NotebookPage extends AbstractPage {
    // there are another localors, if test fails
    private static String logo = "//h1[@class='schema-header__title']";
    private static String asusProducer = "//label[@class='schema-filter__checkbox-item']/span[text()='ASUS'][1]";
    private static String minPrice = "//input[@placeholder='от']";
    //private static String maxPrice = "//input[contains(@class,'schema-filter__number-input_price') and contains(@data-bind,'до')]";
    private static String maxPrice = "//div[@class=\"schema-filter-control schema-filter-control_input\"][2]/child::input[@class=\"schema-filter-control__item schema-filter__number-input schema-filter__number-input_price\"]";
    //private static String year2019 = "//label[@class='schema-filter__checkbox-item']/span[text()='2019']";
    private static String year2019 = "//*[@id=\"schema-filter\"]/div[3]/div[10]/div[3]/ul/li[2]/label/span[2]";
    //private static String results = "//div[@class='schema-product__title']";
    private static String results = "//div[@class='js-schema-results schema-grid__center-column']";


    public static NotebookPage getNotebookPage() {
        NotebookPage notebookPage = new NotebookPage();
        waitForElementVisible(getElementBy(logo));
        System.out.println("Notebook page is opened");
        return notebookPage;
    }

    public NotebookPage tickAsusProducer() {
        getElement(asusProducer).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Asus checkbox is ticked");
        return getNotebookPage();
    }

    public NotebookPage setMinPrice(String minimum) {
        getElement(minPrice).sendKeys(minimum);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Min price is set");
        return getNotebookPage();
    }

    public NotebookPage setMaxPrice(String maximum) {
        getElement(maxPrice).sendKeys(maximum);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Max price is set");
        return getNotebookPage();
    }

    public NotebookPage tickYear2019() throws InterruptedException {
        waitForElementClickable(year2019);
        getElement(year2019).click();
        Thread.sleep(3000);
        //wait(3000);
        //вызывает IllegalMonitorStateException: current thread is not owner, вейт - для написания мультипоточных приложений
        System.out.println("2019 year checkbox is ticked");
        return getNotebookPage();
    }

    public int getResults() {
        return getElements(results).size();
    }
}
