package Sliding_Window;

public class Minimum_Size_Subarray_Sum {

    private int solution(int[] arr, int key) {
        int l = 0, r = 0, res = Integer.MAX_VALUE;
        int total = 0;
        for (r = 0; r < arr.length; r++) {
            total += arr[r];
            while (total >= key) {
                res = Math.min(res, r - l + 1);
                total -= arr[l];
                l += 1;
            }
        }
        return (res == Integer.MAX_VALUE) ? 0 : res;
    }

    public static void main(String[] args) {
        Minimum_Size_Subarray_Sum ob = new Minimum_Size_Subarray_Sum();
        int arr[] = { 2, 3, 1, 2, 4, 3 };
        int key = 7;
        System.out.println(ob.solution(arr, key));
    }
}
