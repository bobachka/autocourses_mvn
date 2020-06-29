package hw11.entities.helpers;

import hw11.entities.pages.NotebookPage;

public class NotebookHelper extends AbstractHelper {
    private NotebookPage notebookPage = new NotebookPage();

    public void setFilters() throws InterruptedException {
        System.out.println("Filters gonna be set");
        notebookPage.setMinPrice("200");
        notebookPage.setMaxPrice("1500");
        notebookPage.tickAsusProducer();
        notebookPage.tickYear2019();
    }

    public int getSearchResults() {
        return notebookPage.getResults();
    }
}
