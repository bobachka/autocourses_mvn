package practicalTasks.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentReminderTest {

    @Test(dataProvider = "providerDaysInterval")
    public void test_days_are_valid(int daysInterval) {
        System.out.println("Reminder is sent after " + daysInterval + " day(s)");
    }

    @DataProvider(name = "providerDaysInterval")
    public Object[][] provideData() {
        return new Object[][]{{1}, {5}, {30}, {365}};
    }
}
