package Code_Force;

import java.util.Scanner;

public class Come_Together {

    private int getDistance(int distance[][]) {
        int ab = 0, ac = 0, bc = 0;
        ab = Math.abs(distance[0][0] - distance[1][0]) + Math.abs(distance[0][1] - distance[1][1]);
        ac = Math.abs(distance[2][0] - distance[0][0]) + Math.abs(distance[0][1] - distance[2][1]);
        bc = Math.abs(distance[1][0] - distance[2][0]) + Math.abs(distance[1][1] - distance[2][1]);
        return ((ab + ac) - bc) / 2 + 1;
    }

    public static void main(String[] args) {
        Come_Together ob = new Come_Together();
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
            int[][] distance = new int[3][2];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2; k++) {
                    distance[j][k] = cin.nextInt();
                }
            }
            res[i] = ob.getDistance(distance);
        }
        for (int num : res)
            System.out.println(num);
        cin.close();
    }
}
