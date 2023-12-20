package Sliding_Window;

public class Maximum_Average_Subarray_I {

    public double solution(int[] arr, int k) {
        int i = 0, j = 0;
        double sum = 0.0;
        double res = 0.0;
        while (j < arr.length) {
            sum += arr[j++];
            if (j - i == k) {
                double average = sum / k;
                res = Math.max(res, average);
                sum -= arr[i++];
            }
        }
        return res;
    }

    public double solution1(int[] arr, int k) {
        int i = 0, j = 0;
        int currsum = 0;
        int maxsum = 0;
        while (j < k) 
            currsum += arr[j++];
        maxsum = currsum;

        while (j < arr.length) {
            currsum -= arr[i++];
            currsum += arr[j++];
            maxsum = Math.max(maxsum, currsum);
        }

        return maxsum * 1.0 / k;
    }

    public static void main(String[] args) {
        Maximum_Average_Subarray_I ob = new Maximum_Average_Subarray_I();
        int arr[] = { 1,12,-5,-6,50,3 };
        System.out.println(ob.solution(arr, 4));
        System.out.println(ob.solution1(arr,4 ));
    }
}
