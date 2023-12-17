package Code_Force;

import java.util.Scanner;

public class IDEraser {

    private int eraser(String str, int k) {
        int count = 0;
        int i = 0;
        int n = str.length();
        while (i < n) {
            if (str.charAt(i) == 'W'){
                i++;
                continue;
            }
            else if (i < n) {
                // System.out.println(i);
                count++;
                i += k;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        IDEraser ob = new IDEraser();
        Scanner cin = new Scanner(System.in);
        // int t = cin.nextInt();
        // int[] res=new int[t];
        // for (int i = 0; i < t; i++) {
        //     int n = cin.nextInt();
        //     n = n - 1;
        //     int k = cin.nextInt();
        //     String str = cin.next();
        //     res[i] = ob.eraser(str, k);
        // }
        // for (int i = 0; i < t; i++) {
        //     System.out.println(res[i]);
        // }
        String str = "WBBWBBWBBW";
        int k = 5;
        System.out.println(ob.eraser(str, k));
        cin.close();
        System.gc();
    }
}
