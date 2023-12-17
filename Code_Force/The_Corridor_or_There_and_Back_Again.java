package Code_Force;

import java.util.Scanner;

public class The_Corridor_or_There_and_Back_Again {

    private int findMax(int[][] arr) {
        int n = arr.length;
        int maxsofar = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] % 2 == 0) {
                maxsofar = arr[i][0] + arr[i][1] / 2 - 1;
                res = Math.min(res, maxsofar);
            } else if (arr[i][1] % 2 == 1) {
                maxsofar = arr[i][0] + arr[i][1] / 2;
                res = Math.min(res, maxsofar);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        The_Corridor_or_There_and_Back_Again ob = new The_Corridor_or_There_and_Back_Again();
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            int n = cin.nextInt();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                arr[j][0] = cin.nextInt();
                arr[j][1] = cin.nextInt();
            }
            res[i] = ob.findMax(arr);
        }
        for (int num : res)
            System.out.println(num);
        cin.close();
    }
}
