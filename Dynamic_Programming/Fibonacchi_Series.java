package Dynamic_Programming;

import java.util.Arrays;

public class Fibonacchi_Series {

    private int fibonacci(int n, int[] t) {
        if (n <= 1)
            return n;
        if (t[n] != -1)
            return t[n];
        return t[n] = fibonacci(n - 1, t) + fibonacci(n - 2, t);
    }

    private int fibonacci(int n) {
        // i-1 -> prev1
        // i-2 -> prev2
        int prev1 = 1;
        int prev2 = 0;
        int curr = 1;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        Fibonacchi_Series ob = new Fibonacchi_Series();
        int n = 13;
        int[] t = new int[n + 1];
        Arrays.fill(t, -1);
        System.out.println(ob.fibonacci(n, t));
        System.out.println(ob.fibonacci(n));
        System.gc();
    }
}
