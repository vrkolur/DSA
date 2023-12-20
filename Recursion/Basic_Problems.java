package Recursion;

public class Basic_Problems {

    public void function(int n) {
        if (n > 0) {
            function(n - 1);
            System.out.print(n + " ");
        }
    }

    public int sum(int n) {
        if (n == 0)
            return 0;
        return n + sum(n - 1);
    }

    public int power(int b, int p) {
        if (p == 0)
            return 1;
        return b * power(b, p - 1);
    }

    int count = 0;

    public void level1(int n) {
        if (n > 0) {
            count++;
            System.out.print(count+" ");
            level1(n - 1);
            level1(n - 1);
        }

    }

    public static void main(String[] args) {
        Basic_Problems ob = new Basic_Problems();
        // System.out.println(ob.sum(4));
        // System.out.println(ob.power(4,3));
        ob.level1(5);
        // ob.function(5);
    }
}
