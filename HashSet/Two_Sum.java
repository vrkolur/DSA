package HashSet;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

    public static int[] solution(int[] arr, int key) {
        Map<Integer, Integer> arr_map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = key - arr[i];
            if (arr_map.containsKey(complement))
                return new int[] { arr_map.get(complement), i };
            arr_map.put(arr[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int key = 9;
        int res[] = solution(arr, key);
        for (int i : res) {
            System.out.println(i);
        }
    }
}