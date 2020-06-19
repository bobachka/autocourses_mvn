package hw9.Listener;

// 1. Написать 4 автотеста, 2 из них - passed, 1 - failed, 1 - skipped.
// 2. Подключить ITestListener, и в методах этого листенера вывести данные по результатам тестов (какие прошли, какие нет).
// 3. Подключить репортер
// 4. Запустить через testing.xml и убедиться, что статистика по прогону вывелась, а репорт сгенерился.

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test " + result.getName() + " started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test " + result.getName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test " + result.getName() + " failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test " + result.getName() + " is skipped.");
    }
}
