package Code_Force;

import java.util.Scanner;

public class Two_Vessels {

    private int twoVessels(int a, int b, int c) {
        int res = 0;
        int diff = Math.abs(a - b);
        res = diff / (c * 2);
        if (c == 1 && diff % 2 != 0) {
            res++;
            return res;
        }
        if (diff % (c * 2) > 0)
            res++;
        return res;
    }

    public static void main(String[] args) {
        Two_Vessels ob = new Two_Vessels();
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        int a, b, c;
        int[] res = new int[t];
        for (int i = 0; i < t; i++) {
        a = cin.nextInt();
        b = cin.nextInt();
        c = cin.nextInt();
        res[i] = ob.twoVessels(a, b, c);
        }
        for (int i = 0; i < t; i++) {
        System.out.println(res[i]);
        }
        // System.out.println(ob.twoVessels(97, 4, 3));
        cin.close();
    }
}
