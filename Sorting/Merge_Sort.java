package Sorting;

public class Merge_Sort {

    public static void merge(int arr[], int l, int mid, int r) {
        // Make two temporary arrays
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] a = new int[n1];
        int[] b = new int[n2]; // Temp arrays

        for (int i = 0; i < n1; i++) {
            a[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            b[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }
        }

        while (i < n1) {
            arr[k++] = a[i++];
        }
        while (j < n2) {
            arr[k++] = b[j++];
        }

    }

    public static void mergesort(int arr[], int l, int r) {

        if (l < r) {
            int mid = (l + r) / 2;

            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args) {

        int[] arr = { 34, 67, 12, 3, 4, 5, 89, 0,-98 };
        mergesort(arr, 0, (arr.length - 1));
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
