package problem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] p = {1500, 3000, 2000};
        int[] w = {1, 4, 3};
        int V = 4;

        int[][] f = new int[p.length + 1][V + 1];
        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[i].length; j++) {
                if (w[i - 1] > j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    if (f[i - 1][j] < p[i - 1] + f[i - 1][j - w[i - 1]]) {
                        f[i][j] = p[i - 1] + f[i - 1][j - w[i - 1]];
                    } else {
                        f[i][j] = f[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < f.length; i++) {
            System.out.println(Arrays.toString(f[i]));
        }
    }
}
