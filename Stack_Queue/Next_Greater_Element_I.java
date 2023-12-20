package Stack_Queue;

// import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List;
import java.util.Stack;

public class Next_Greater_Element_I {

    public int[] solution(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        // we are going to have a monotonicallyy decreasing stack.
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        // System.out.println(map.containsKey(4));
        for (int i = 0; i < nums2.length; i++) {
            int curr = nums2[i];
            while (s.size() > 0 && curr > s.peek()) {
                int val = s.pop();
                int indx = map.get(val);
                res[indx] = curr;
            }
            if (map.containsKey(curr)) {
                s.add(curr);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Next_Greater_Element_I ob = new Next_Greater_Element_I();
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 2, 1, 3, 4 };
        int[] res = ob.solution(nums1, nums2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}