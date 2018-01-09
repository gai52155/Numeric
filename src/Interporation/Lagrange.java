package Interporation;

public class Lagrange {

    public static double calculate(double t, double x[], int index) {
        double upper = 1.0, lower = 1.0;
        double ans;
        for (int i = 0; i < x.length; i++) {
            if (i != index) {
                upper = upper * (t - x[i]);
                lower = lower * (x[index] - x[i]);
            }
        }
        ans = upper / lower;
        return ans;
    }

    public static void main(String[] args) {
        double x[] = new double[]{4, 8, 100};
        double f[] = new double[]{2, 18, 16};
        int n = x.length;
        double ln[] = new double[n];
        double t = 108;
        double check = 0.0, ans = 0.0;
        for (int i = 0; i < n; i++) {
            ln[i] = calculate(t, x, i);
            check = check + ln[i];
            System.out.println("ln[" + i + "] = " + ln[i]);
            ans = ans + f[i] * ln[i];
        }
        System.out.println("CHECK = " + check);
        System.out.println("answer = " + ans);
    }
}
