package Stack_Queue;

import java.util.Stack;

public class Maximum_Subarray_Min_Product {

    public int maxSumMinProduct(int[] arr) {
        int maxans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += arr[j];
                // System.out.println(min);
                // System.out.println(min*sum);
                maxans = Math.max(maxans, min * sum);
            }
        }
        return maxans;
    }

    public int maxSumMinProduct1(int[] arr) {
        long res = 0;

        Stack<long[]> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            while (s.size() > 0 && s.peek()[0] > arr[i]) {
                long[] cur = s.pop();
                res = Math.max(res, cur[0] * (cur[1] + sum));
                sum += cur[1];
            }
            s.push(new long[] { arr[i], sum + arr[i] });
        }
        long sum=0;
        while(!s.isEmpty()) {
            long[] cur=s.pop();
            res=Math.max(res, cur[0]*(cur[1]+sum));
            sum+=cur[1];
        }
        return (int) (res % 1000000007);
    }

    public static void main(String[] args) {
        Maximum_Subarray_Min_Product ob = new Maximum_Subarray_Min_Product();
        int[] arr = { 1, 2, 3, 2 };
        System.out.println(ob.maxSumMinProduct(arr));
        System.out.println(ob.maxSumMinProduct1(arr));
    }
}
