package Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Nearest_Grater_to_Left {

    public List<Integer> solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (s.size() == 0)
                res.add(-1);
            else if (s.size() > 0 && s.peek() > arr[i]) {
                res.add(s.peek());
            } else if (s.size() > 0 && s.peek() <= arr[i]) {
                while (s.size() > 0 && s.peek() <= arr[i]) {
                    s.pop();
                }
                if (s.size() == 0) {
                    res.add(-1);
                } else {
                    res.add(s.peek());
                }
            }
            s.add(arr[i]);
        }
        return res;
    }

    public List<Integer> solution_idx(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (s.size() == 0) {
                res.add(-1);
            } else if (s.size() > 0 && arr[s.peek()] > arr[i]) {
                res.add(s.peek());
            } else if (s.size() > 0 && arr[s.peek()] <= arr[i]) {
                while (s.size() > 0 && arr[s.peek()] <= arr[i]) {
                    s.pop();
                }
                if (s.size() == 0)
                    res.add(-1);
                else
                    res.add(s.peek());
            }
            s.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Nearest_Grater_to_Left ob = new Nearest_Grater_to_Left();
        int arr[] = { 1, 3, 2, 4 };
        List<Integer> res = ob.solution(arr);
        List<Integer> res1 = ob.solution_idx(arr);
        System.out.println(res);
        System.out.println(res1);
    }
}
