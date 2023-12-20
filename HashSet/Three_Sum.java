package HashSet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Three_Sum {
    private List<List<Integer>> solution(int arr[]) {
        Arrays.sort(arr);
        List<List<Integer>> out_arr = new LinkedList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || (i > 0 && arr[i - 1] != arr[i])) {
                int l = i + 1;
                int r = arr.length - 1;
                int sum = 0 - arr[i];

                while (l < r) {
                    if (arr[l] + arr[r] == sum) {
                        out_arr.add(Arrays.asList(arr[i], arr[l], arr[r]));
                        while (l < r && arr[l] == arr[l + 1])
                            l++;
                        while (l < r && arr[r] == arr[r - 1])
                            r--;
                        l++;
                        r--;
                    } else if (arr[l] + arr[r] > sum)
                        r--;
                    else
                        l++;
                }
            }
        }
        return out_arr;
    }

    public static void main(String[] args) {
        Three_Sum ob = new Three_Sum();
        int[] arr = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> res = ob.solution(arr);
        System.out.println(res);
    }
}
