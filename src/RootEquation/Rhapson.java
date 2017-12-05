package RootEquation;

public class Rhapson {

    public static double f(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) + x - 1;
    }

    public static double df(double x) {
        return 3 * Math.pow(x, 2) + 2 * x + 1;
    }

    public static void main(String[] args) {
        double p0 = 10, p1;
        boolean flag = true;
        int n = 0;
        while (flag) {
            p1 = p0 - (f(p0) / df(p0));
            System.out.println(p1);
            if ((f(p1) == 0)) {
                flag = false;
                System.out.println("FOUND AT : " + n + " ROOT = " + p1 + " (f(p1) = " + f(p1) + ")");
            } else {
                p0 = p1;
            }
            n++;
        }
    }

}
