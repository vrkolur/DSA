package Sorting;

public class Wave_Sort {

    public static void swap(int[] arr, int x, int y) {

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void sort(int[] arr, int n) {
        for (int i = 1; i < n; i += 2) {

            if (arr[i] > arr[i - 1]) {
                swap(arr, i, i - 1);
            }
            if (arr[i] > arr[i + 1] && i <= n - 2) {
                swap(arr, i, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 7, 5, 6, 2 };
        sort(arr, (arr.length ));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
