// package Code_Force;

import java.util.Scanner;

public class Even_Odds {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        long n = cin.nextInt();
        long k = cin.nextInt();

        if (k <= (n + 1) / 2) {
            System.out.println(k*2-1);
        } else
        System.out.println((k-(n+1)/2)*2);
        cin.close();
    }
}
