package RootEquation;

public class Secant {

    public static double f(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) + x - 1;
    }

    public static void main(String[] args) {
        double x0 = 8, x1 = 4, x2;
        boolean flag = true;
        int n = 0;
        while (flag) {
            x2 = x1 - ((f(x1) * (x1 - x0)) / (f(x1) - f(x0)));
            System.out.println(x2);
            if (f(x2) == 0) {
                flag = false;
                System.out.println("FOUND AT : " + n + " ROOT = " + x2 + " (f(x2) = " + f(x2) + ")");
            } else {
                x0 = x1;
                x1 = x2;
            }
            n++;
        }
    }

}
