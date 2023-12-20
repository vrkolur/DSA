package Sliding_Window;

import java.util.HashMap;

public class Contains_Duplicate_III {
    
    private boolean solution(int[] arr, int idxDiff, int valDiff) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (map.containsKey(curr) && i - map.get(curr) <= idxDiff && arr[i] - arr[map.get(curr)] <= valDiff) {
                return true;
            } else {
                map.put(curr, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Contains_Duplicate_III ob = new Contains_Duplicate_III();
        int[] arr = { 8,7,15,1,6,1,9,15 };
        System.out.println(ob.solution(arr, 1, 3));
    }
}
