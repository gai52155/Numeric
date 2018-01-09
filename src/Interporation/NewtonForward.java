package Interporation;

public class NewtonForward {

    public static long fac(long l) {
        if (l <= 1.0) {
            return 1;
        }
        return l * fac(l - 1);
    }

    public static double uterm(double p, int x) {
        double ans = 1.0;
        for (int i = 0; i < x; i++) {
            if (i == 0) {
                ans = ans * p;
            } else {
                ans = ans * (p - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        double x[] = new double[]{0.0, 0.1, 0.2, 0.3, 0.4};
        double f[] = new double[]{3.2, 6.4, 5.2, 3.0, 1.4};
        double h = x[1] - x[0];
        double p = 0.5;
        int n = x.length;
        double fx[][] = new double[n][n];

        for (int i = 0; i < n; i++) {
            fx[i][0] = f[i];
        }

        // GENERATE DATA
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                fx[j][i] = fx[j + 1][i - 1] - fx[j][i - 1];
                System.out.print(fx[j][i] + " ");
            }
            System.out.println();
        }
        // CALCULATE ANS
        double ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (fx[0][i] * uterm(p, i)) / (fac(i) * Math.pow(h, i));
        }
        System.out.print(ans);
    }
}
