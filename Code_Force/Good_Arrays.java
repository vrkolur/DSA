package Code_Force;

import java.util.Scanner;

public class Good_Arrays {

    private boolean isGood(int[] arr) {
        int sum = 0;
        int count1 = 0;
        for (int num : arr) {
            sum += num;
            if (num == 1)
                count1++;
        }
        if (sum > count1 + arr.length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Good_Arrays ob = new Good_Arrays();
        Scanner cin = new Scanner(System.in);

        int t = cin.nextInt();
        boolean[] res = new boolean[t];
        for (int i = 0; i < t; i++) {
            int n = cin.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[i] = cin.nextInt();
            res[i] = ob.isGood(arr);
        }
        for (boolean it : res) {
            if (it)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        cin.close();
    }
}
