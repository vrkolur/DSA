package Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Nearest_Smallest_Left {

    public List<Integer> solution(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0)
                res.add(-1);
            else if (st.size() > 0 && st.peek() < arr[i]) {
                res.add(st.peek());
            } else if (st.size() > 0 && st.peek() >= arr[i]) {
                while (st.size() > 0 && st.peek() >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0)
                    res.add(-1);
                else
                    res.add(st.peek());
            }
            st.push(arr[i]);
        }
        return res;
    }

    public int[] solution1(int[] arr) {
        int nsl[] = new int[arr.length];
        nsl[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            int p = i - 1;
            while (p >= 0 && arr[p] >= arr[i]) {
                p = nsl[p];
            }
            nsl[i] = p;
        }
        return nsl;
    }

    public static void main(String[] args) {
        Nearest_Smallest_Left ob = new Nearest_Smallest_Left();
        int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
        int arr1[] = { 4, 5, 2, 10, 8 };
        int res[] = ob.solution1(arr);
        System.out.println(ob.solution(arr1));
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
