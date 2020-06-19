package hw10;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OzPageTest {
    private OzPage ozPage;

    @BeforeClass
    public void goToOz() {
        ozPage = new OzPage();
        ozPage.navigateToOz("https://oz.by/");
    }

    @Test
    public void verifyPresence() {
        ozPage.verifySearchFldPresence();
        ozPage.verifyLoginBtnPresence();
        ozPage.verifyShoppingCartBtnPresence();
        ozPage.verifyFiltersPresence();

        Assert.assertTrue(ozPage.verifyAllElements());
    }

    @AfterClass
    public void tearDown() {
        ozPage.closeWindow();
    }
}
