import java.util.Scanner;

abstract class ColorModel {
    public abstract void convert();
}

class RGBconverter extends ColorModel {
    private int r, g, b;

    public RGBconverter(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void convert() {
        double c = 1 - (r / 255.0);
        double m = 1 - (g / 255.0);
        double y = 1 - (b / 255.0);
        double k = Math.min(c, Math.min(m, y));

        if (k < 1) {
            c = (c - k) / (1 - k);
            m = (m - k) / (1 - k);
            y = (y - k) / (1 - k);
        } else {
            c = 0;
            m = 0;
            y = 0;
        }

        System.out.printf("CMYK: %.2f, %.2f, %.2f, %.2f\n", c, m, y, k);
    }
}

class CMYKconverter extends ColorModel {
    private double c, m, y, k;

    public CMYKconverter(double c, double m, double y, double k) {
        this.c = c;
        this.m = m;
        this.y = y;
        this.k = k;
    }

    @Override
    public void convert() {
        int r = (int) (255 * (1 - c) * (1 - k));
        int g = (int) (255 * (1 - m) * (1 - k));
        int b = (int) (255 * (1 - y) * (1 - k));

        System.out.printf("RGB: %d, %d, %d\n", r, g, b);
    }
}

public class Task_26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения CMYK (через пробел): ");
        double c = scanner.nextDouble();
        double m = scanner.nextDouble();
        double y = scanner.nextDouble();
        double k = scanner.nextDouble();

        ColorModel cmykConverter = new CMYKconverter(c, m, y, k);
        cmykConverter.convert();
    }
}
