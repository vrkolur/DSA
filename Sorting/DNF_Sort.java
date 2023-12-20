package Sorting;

public class DNF_Sort {

    public static void swap(int[] arr, int x, int y) {
        int temp;
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void sort(int arr[], int n) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 0, 1, 0, 2, 0, 1, 0, 2, 1, 0, 2, 0, 1, 2, 1, 2, 0, 1, 2 };
        sort(arr, (arr.length - 1));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
