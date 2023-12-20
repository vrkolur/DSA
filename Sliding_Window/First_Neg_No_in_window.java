package Sliding_Window;

import java.util.ArrayList;
import java.util.List;

public class First_Neg_No_in_window {

    private List<Integer> solution(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();

        int i = 0, n = arr.length;

        while (i < n && k <= n) {
            int j = i;
            while (j < k) {
                if (arr[j] < 0) {
                    res.add(arr[j]);
                    break;
                }
                j++;
            }
            if (j == k)
                res.add(0);
            i++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        First_Neg_No_in_window ob = new First_Neg_No_in_window();
        int arr[] = { 12, -1, -7, 8, -15, 30, 18, 28,-69 };
        System.out.println(ob.solution(arr, 3));
    }
}
