package Sliding_Window;

// import java.sql.Ref;
import java.util.HashMap;

public class Longest_Sub_Array_with_Sum_K {

    private int solution(int[] arr, int k) {

        HashMap<Integer, Integer> prefix_sum = new HashMap<>();
        int res = 0;
        int sum = 0;
        prefix_sum.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (prefix_sum.containsKey(sum - k)) {
                res += prefix_sum.get(sum - k);
            }

            prefix_sum.put(sum, prefix_sum.getOrDefault(sum, 0) + 1);
        }
        return res;

    }

    private int solution1(int[] arr, int k) {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        int n = arr.length;
        // traverse the given array
        for (int i = 0; i < n; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // put into the hashmap if sum not present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {
                System.out.println(map.get(sum - k));
                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Longest_Sub_Array_with_Sum_K ob = new Longest_Sub_Array_with_Sum_K();
        int arr[] = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        ob.solution(arr, k);
        System.out.println(ob.solution1(arr, k));
    }
}
