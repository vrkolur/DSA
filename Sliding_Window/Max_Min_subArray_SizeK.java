package Sliding_Window;

public class Max_Min_subArray_SizeK {
    
    private int maxsolution(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return max;
    }
    private int minsolution(int[] arr, int k) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k)
                j++;
            else if (j - i + 1 == k) {
                min = Math.min(min, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        Max_Min_subArray_SizeK ob = new Max_Min_subArray_SizeK();
        int[] arr = { 5, 8, 7, 4, 3, 6, 5, 8, 7, 4 };
        System.out.println(ob.maxsolution(arr, 2));
        System.out.println(ob.minsolution(arr, 3));
    }
}
 