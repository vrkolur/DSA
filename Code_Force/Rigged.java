package Code_Force;

import java.util.Scanner;

public class Rigged {

    private int solution(int[][] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0][0];
        int x= arr[0][0];
        int y = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= x && arr[i][1] >= y)
                return -1;
        }
        return x;
        
    }

    public static void main(String[] args) {
        Rigged ob = new Rigged();
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int[] res = new int[t];
        for (int k = 0; k < t; k++) {
            int n = cin.nextInt();
            int[][] parameters = new int[n][2];
            for (int i = 0; i < n; i++) {
                parameters[i][0] = cin.nextInt();
                parameters[i][1] = cin.nextInt();
            }
            res[k] = ob.solution(parameters);
        }
        for (int num : res)
            System.out.println(num);
        cin.close();
    }
}
