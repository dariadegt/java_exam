import java.util.Scanner;

abstract class Function {
    public abstract double calculate(double x);
}

class LinearFunction extends Function {
    private double a, b;

    public LinearFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate(double x) {
        return a * x + b;
    }
}

class QuadraticFunction extends Function {
    private double a, b, c;

    public QuadraticFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculate(double x) {
        return a * x * x + b * x + c;
    }
}

public class Task_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение x: ");
        double x = scanner.nextDouble();

        Function linear = new LinearFunction(2, 3);
        Function quadratic = new QuadraticFunction(1, -2, 1);

        System.out.println("Значение линейной функции: " + linear.calculate(x));
        System.out.println("Значение квадратичной функции: " + quadratic.calculate(x));
    }
}
