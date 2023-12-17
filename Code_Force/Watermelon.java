package Code_Force;

import java.util.Scanner;

public class Watermelon {

public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    if (n % 2 == 0 && n>1)
        System.out.println("YES");
    else
    System.out.println("NO");
    cin.close();
}
}
