package hw9.Listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ClassWithTests {
    @Test
    public void test1() {
    }

    @Test
    public void test2() {
    }

    @Test
    public void test3() {
        Assert.fail();
    }

    @Test
    public void test4() {
        throw new SkipException("Skipping this exception");
    }
}
