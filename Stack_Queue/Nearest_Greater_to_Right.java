package Stack_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Nearest_Greater_to_Right {

    public List<Integer> solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.size() == 0) {
                res.add(-1);
            } else if (s.size() > 0 && s.peek() > arr[i]) {
                res.add(s.peek());
            } else if (s.size() > 0 && s.peek() <= arr[i]) {
                while (s.size() > 0 && s.peek() <= arr[i]) {
                    s.pop();
                }
                if (s.size() == 0)
                    res.add(-1);
                else
                    res.add(s.peek());
            }
            s.add(arr[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        Nearest_Greater_to_Right ob = new Nearest_Greater_to_Right();
        int arr[] = { 1, 3, 2, 4 };
        List<Integer> res = ob.solution(arr);
        Collections.reverse(res);
        System.out.println(res);
    }
}
