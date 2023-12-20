package Recursion;

public class RecursionTest {

    public static void printNum(int n) {
        if (n == 0) {
            return;
        }
        printNum(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int powerof(int x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        return x * powerof(x, n - 1);
    }

    public static void reverseString(String str, int idx) {
        if (idx == 0) {
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        reverseString(str, idx - 1);
    }

    public static boolean isSorted(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return true;
        }
        if (arr[idx] < arr[idx + 1]) {
            // array is sorted till here
            return isSorted(arr, idx + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // int n = 5;
        int[] arr = { 1, 2, 3, 4, 5, 5, 6 };
        // String str = "xxabxxcxdxxxexfxxgxx";
        // printNum(n);
        // System.out.println(factorial(n));
        // System.out.println(powerof(2, 10));
        // reverseString(str, str.length() - 1);
        System.out.println(isSorted(arr, 0));
    }
}
