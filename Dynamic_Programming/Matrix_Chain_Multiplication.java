package Dynamic_Programming;

import java.util.Arrays;

public class Matrix_Chain_Multiplication {

    // Recursive approach
    // see notes for detail explanantion

    private int mcm(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        int res = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost = mcm(arr, i, k)
                    + mcm(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];
            if (cost < res) {
                res = cost;
            }
        }
        return res;
    }

    // Memozised approach use t[n+1][n+1].

    private int mcm(int[] arr, int i, int j, int[][] t) {

        if (i == j)
            return 0;
        if (t[i][j] != -1)
            return t[i][j];

        t[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            t[i][j] = Math.min(t[i][j],
                    mcm(arr, i, k, t)
                            + mcm(arr, k + 1, j, t)
                            + arr[i - 1] * arr[k] * arr[j]);
        }

        return t[i][j];
    }

    // Dynamic Approach
    // now since bottom up upproach i=n-1->0 from the bottom of the table till up(the biggest one).
    // then j is i+1->n because j>i 
    private int mcm(int[] arr) {
        int n = arr.length;
        int[][] t = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++)
            t[i][i] = 0;

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    mini = Math.min(mini, t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
                }
                t[i][j] = mini;
            }
        }
        return t[1][n - 1];
    }

    public static void main(String[] args) {
        Matrix_Chain_Multiplication ob = new Matrix_Chain_Multiplication();
        int[] arr = { 40, 20, 30, 10, 30 };
        System.out.println(ob.mcm(arr, 1, arr.length - 1));
        int n = arr.length;
        int[][] t = new int[n + 1][n + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.mcm(arr, 1, n - 1, t));
        System.out.println(ob.mcm(arr));
    }
}
