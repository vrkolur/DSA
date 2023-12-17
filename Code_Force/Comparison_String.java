package Code_Force;

import java.util.Scanner;

public class Comparison_String {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            int n = cin.nextInt();
            String s = cin.next();
            int max = 1, ans = 1;
            for (int j = 1; j < n; j++) {
                if (s.charAt(j) != s.charAt(j - 1))
                    ans = 1;
                else
                    ans++;
                max = Math.max(max, ans);
            }
            res[i] = max;
        }
        for (int num : res)
            System.out.println(num + 1);
        System.gc();
        cin.close();
    }
}
