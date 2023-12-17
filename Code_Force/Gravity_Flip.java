// package Code_Force;

import java.util.Arrays;
import java.util.Scanner;

public class Gravity_Flip {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] arr = new int[n];
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[--count[arr[i]]] = arr[i];
        }
        for(int num:res)System.out.print(num+" ");
        cin.close();
    }
}
