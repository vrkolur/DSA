package Stack_Queue;

import java.util.Stack;

public class Daily_Temperatures {

    public int[] soluition(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.size() == 0) {
                res[i] = 0;
            }
            if (st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[i] = (st.peek() - i);
            }
            else if (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0)
                    res[i] = 0;
                else
                    res[i] = (st.peek() - i);
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Daily_Temperatures ob = new Daily_Temperatures();
        int[] temp = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] res = ob.soluition(temp);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }   
}
