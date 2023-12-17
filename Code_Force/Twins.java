package Code_Force;

import java.util.Arrays;
import java.util.Scanner;

public class Twins {
    
    public static void main(String[] args) {
        Scanner cin = new Scanner((System.in));
        int n = cin.nextInt();
        int[] arr = new int[n];
        int twin1 = 0,twin2=0;
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
            twin1 += arr[i];
        }
        Arrays.sort(arr);
        int i = 0;
        while (twin1 > twin2) {
            if (twin1 - arr[i] > twin2 + arr[i]) {
                twin1 -= arr[i];
                twin2 += arr[i];
                i++;
            } else
                break;
        }
    System.out.println(n-i);
            cin.close();
    }
}
