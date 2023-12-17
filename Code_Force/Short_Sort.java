package Code_Force;

import java.util.Scanner;

public class Short_Sort {

    private boolean sort(String str) {
        if (str.charAt(0) == 'a' || str.charAt(1) == 'b' || str.charAt(2) == 'c')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Short_Sort ob = new Short_Sort();
        Scanner cin = new Scanner(System.in);

        int t = cin.nextInt();
        boolean[] res = new boolean[t];
        for (int i = 0; i < t; i++) {
            String s = cin.next();
            res[i] = ob.sort(s);
        }
        for (boolean it : res) {
            if(it)
                System.out.println("YES");
            else 
            System.out.println("NO");
        }
        cin.close();
    }
}
