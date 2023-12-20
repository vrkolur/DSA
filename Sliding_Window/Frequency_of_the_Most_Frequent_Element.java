package Sliding_Window;

public class Frequency_of_the_Most_Frequent_Element {
    private int solution(int[] arr, int k) {
        int l = 0, r = 0, maxlen = 0, total = 0;

        while (r < arr.length) {
            total += arr[r];
            while (arr[r] * (r - l + 1) > total + k) {
                total -= arr[l];
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Frequency_of_the_Most_Frequent_Element ob = new Frequency_of_the_Most_Frequent_Element();
        int arr[] = {1,1,1,2,2,4 };
        int k = 2;
        System.out.println(ob.solution(arr, k));
    }
}
