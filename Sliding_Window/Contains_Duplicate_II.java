package Sliding_Window;

import java.util.HashMap;

public class Contains_Duplicate_II {

    public boolean solution(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (map.containsKey(current) && i - map.get(current) <= k)
                return true;
            else
                map.put(current, i);
        } // map.key->value of the array and map.value->indices;
        return false;
    }

    public static void main(String[] args) {
        Contains_Duplicate_II ob = new Contains_Duplicate_II();
        int[] arr = { 1,89,89,1 };
        System.out.println(ob.solution(arr, 1));
    }
}
