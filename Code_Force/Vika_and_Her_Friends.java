package Code_Force;

import java.util.Scanner;

public class  Vika_and_Her_Friends{
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int t = cin.nextInt();
        boolean res[] = new boolean[t];
        for (int i = 0; i < t; i++) {
            //Comment out these to get the corrrect solution.
            // int n = cin.nextInt();
            // int m = cin.nextInt();
            int k = cin.nextInt();
            int x = cin.nextInt();
            int y = cin.nextInt();
            boolean ans = true;
            for (int j = 0; j < k; j++) {
                int x1 = cin.nextInt();
                int y1 = cin.nextInt();
                if ((x + y) % 2 == (x1 + y1) % 2)
                    ans = false;
            }
            res[i] = ans;
        }
        for (boolean ans : res) {
            if (ans)
                System.out.println("YES");
            else System.out.println("NO");
        }
        cin.close();
    }
}
