package Code_Force;

import java.util.Scanner;

public class Football {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.next();
        String s1 = "1111111";
        String s2 = "0000000";
        if (s.indexOf(s1) >= 0 || s.indexOf(s2) >= 0)
            System.out.println("YES");
        else
            System.out.println("NO"); // System.out.println(res);
        cin.close();
    }
}
