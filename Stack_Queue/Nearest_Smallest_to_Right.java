package Stack_Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Nearest_Smallest_to_Right {

    public List<Integer> solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if(st.isEmpty())
                res.add(-1);
            else if (!st.isEmpty() && st.peek() < arr[i]) {
                res.add(st.peek());
            } else if (!st.isEmpty() && st.peek() >= arr[i]) {
                while (!st.isEmpty() && st.peek() >= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty())
                    res.add(-1);
                else
                    res.add(st.peek());
            }
            st.push(arr[i]);
        }
        return res;
    }

    public int[] solution1(int[] arr) {
        int nsr[] = new int[arr.length];
        nsr[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < arr.length && arr[p] >= arr[i])
                p = nsr[p];

            nsr[i] = p;
        }
        return nsr;
    }

    public static void main(String[] args) {
        Nearest_Smallest_to_Right ob = new Nearest_Smallest_to_Right();
        int arr[] = { 4, 5, 2, 10, 8 };
        List<Integer> res = ob.solution(arr);
        Collections.reverse(res);
        System.out.println(res);
        // int arr1[] = { 6, 2, 5, 4, 5, 1, 6 };
        // int[] res = ob.solution1(arr1);
        // for (int i = 0; i < res.length; i++) {
        //     System.out.print(res[i] + " ");
        // }
    }
}
