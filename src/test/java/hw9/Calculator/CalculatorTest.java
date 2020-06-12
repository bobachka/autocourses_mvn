package hw9.Calculator;

// Взять программу Calculator из предыдущей дз, с минимумом 5 мат. действиями
// Написать авт тест на каждое действие.
// Calculator должен быть написан в модуле main maven-проекта
// Каждый авто тест должен быть описан через аннотацию @Test, должен иметь конфигурационные методы.
// Тесты должны запускаться через testng.xml командой mvn clean test.

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator(5, 2);
    private static int a;
    private static int b;

    @BeforeClass
    public void setUpData() {
        a = 5;
        b = 2;
        System.out.println("a = " + a + ", b = " + b);
    }

    @Test
    public void additionTest() {
        int actualResult = calculator.addition();
        int expectedResult = 7;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void subtractionTest() {
        int actualResult = calculator.subtraction();
        int expectedResult = 3;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void multiplicationTest() {
        int actualResult = calculator.multiplication();
        int expectedResult = 10;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void modulusTest() {
        int actualResult = calculator.modulus();
        int expectedResult = 1;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void divisionTest() {
        double actualResult = calculator.division();
        double expectedResult = 2.0;
        Assert.assertEquals(actualResult, expectedResult);
    }
}