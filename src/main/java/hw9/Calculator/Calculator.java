package hw9.Calculator;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(5, 2);
        calculator.addition();
        calculator.subtraction();
        calculator.multiplication();
        calculator.modulus();
        calculator.division();
    }

    private int a;
    private int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addition() {
        System.out.println("Addition result is " + (a + b));
        return a + b;
    }

    public int subtraction() {
        System.out.println("Subtraction result is " + (a - b));
        return a - b;
    }

    public int multiplication() {
        System.out.println("Multiplication result is " + (a * b));
        return a * b;
    }

    public int modulus() {
        System.out.println("Modulus result is " + (a % b));
        return a % b;
    }

    public double division() {
        System.out.println("Division result is " + (double) (a / b));
        return (double) (a / b);
    }
}