package Code_Force;

import java.util.Arrays;
import java.util.Scanner;

public class Good_Kid {

    private int goodKid(int[] arr, int n) {
        Arrays.sort(arr);
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] == 0) {
        //         arr[i]++;
        //         break;
        //     } else {

        //     }
        //         arr[i]++;
        // }
        arr[0]++;
        int ans = 1;
        for (int num : arr) {
            ans *= num;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Good_Kid ob=new Good_Kid();
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            int n = cin.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = cin.nextInt();
            res[i] = ob.goodKid(arr, n);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }
        cin.close();
    }
}
