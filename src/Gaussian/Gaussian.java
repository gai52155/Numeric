package gaussian;

public class Gaussian {

    public static void main(String[] args) {
        int[] A = new int[]{5, 10, 9,
            10, 26, 26,
            15, 54, 66};
        int[] B = new int[]{4,
            10,
            27};
        int n = B.length;
        double ab[][] = new double[n][n + 1];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i][j] = A[temp];
                temp++;
            }
            ab[i][n] = B[i];
        }

        double m;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                m = ab[j][i] / ab[i][i];
                for (int k = i; k <= n; k++) {
                    ab[j][k] = ab[j][k] - (m * ab[i][k]);
                }
            }
        }

        System.out.println("---------------------------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(ab[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("------BACKWARD----------");
        double var[] = new double[3];
        double temp2 = 0.0;
        double det = 1.0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if ((j - 1) == i) {
                    det = det * ab[i][j - 1];
                    var[i] = (ab[i][n] - temp2) / ab[i][j - 1];
                } else {
                    temp2 = temp2 + ab[i][j - 1] * var[j - 1];
                }
            }
            temp2 = 0.0;
        }
        System.out.println("X = " + var[0]);
        System.out.println("Y = " + var[1]);
        System.out.println("Z = " + var[2]);
        System.out.println("DET = " + det); //BONUS

        System.out.println("---------------PROOF ZONE---------------");
        double ans = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ab[i][j] + " * " + var[j] + "  ");
                ans = ans + (ab[i][j] * var[j]);
            }
            System.out.print(" = " + ans);
            ans = 0;
            System.out.println();
        }
    }
}
