package Code_Force;

import java.util.Scanner;

public class Ambitious_Kid {
    
    public static void main(String[] args) {
        // Ambitious_Kid ob = new Ambitious_Kid();
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
            res=Math.min(Math.abs(arr[i]), res);
        }
        System.out.println(res);
        cin.close();
    }
}
