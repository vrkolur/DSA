package Stack_Queue;

import java.util.Stack;

public class Asteroid_Collision {

    public int[] soluition(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int ast : arr) {
            if (ast > 0)
                st.push(ast);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast)) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(ast);
                }
                if (st.peek() == Math.abs(ast)) {
                    st.pop();
                }
            }
        }
        return st.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Asteroid_Collision ob = new Asteroid_Collision();
        int[] ast = { 5, 10, -5 };
        int[] res = ob.soluition(ast);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
