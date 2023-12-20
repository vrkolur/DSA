package Stack_Queue;

import java.util.Stack;

public class Valid_Parentheses {

    public boolean solution(String s) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(')');
            else if (ch == '{')
                st.push('}');
            else if (ch == '[')
                st.push(']');
            else if (st.isEmpty() || st.pop() != ch)
                return false;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Valid_Parentheses ob = new Valid_Parentheses();
        String s = "";
        System.out.println(ob.solution(s));
    }
}
