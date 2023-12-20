package Sorting;

public class Quick_Sort {

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static int partition(int[] arr, int l, int r) {

        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }
    

    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r);
            
            quicksort(arr, l, pi - 1);
            quicksort(arr, pi+1, r);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = { 99,58,63,21,45,2,9,4,6 };
        quicksort(arr, 0, (arr.length - 1));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
