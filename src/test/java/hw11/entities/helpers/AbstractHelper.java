package hw11.entities.helpers;

import hw11.entities.pages.AbstractPage;

public class AbstractHelper {

    AbstractPage abstractPage = new AbstractPage();

    public void quit() {
        abstractPage.getDriver().quit();
    }
}