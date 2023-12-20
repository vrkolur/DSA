package Stack_Queue;

import java.util.Stack;

public class Stack_Span_Problem {

    static int[] solution(int arr[]) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i])
                st.pop();
            res[i] = (st.isEmpty()) ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return res;
    }
    

    public static void main(String[] args) {
        int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
        int[] res = solution(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
