package RootEquation;

public class Bisection {

    public static double f(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) + x - 1;
    }

    public static void main(String[] args) {
        double a = 1.0, b = -1.0, c;
        boolean flag = true;
        double error = 0.00001; //10^4
        int n = 0;
        if (f(a) * f(b) < 0) {
            while (flag) {
                c = (a + b) / 2;
                System.out.println(c);
                if ((f(c) == 0) || (Math.abs(f(c)) < error)) {
                    flag = false;
                    System.out.println("FOUND AT : " + n + " ROOT = " + c + " (f(c) = " + f(c) + ")");
                } else if (f(a) * f(c) > 0) {
                    a = c;
                } else {
                    b = c;
                }
                n++;
            }
        }
    }
}
