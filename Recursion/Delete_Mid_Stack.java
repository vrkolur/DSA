package Recursion;

import java.util.Stack;

public class Delete_Mid_Stack {

    public Stack<Integer> delMid(Stack<Integer> s, int mid) {
        if (mid == 1) {
            s.pop();
            return s;
        }
        int temp = s.peek();
        s.pop();
        delMid(s, mid - 1);
        s.push(temp);
        return s;
    }

    public static void main(String[] args) {
        Delete_Mid_Stack ob = new Delete_Mid_Stack();
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < 12; i++) {
            s.push(i);
        }
        System.out.println(s);
        int mid = s.size() / 2 + 1;
        // System.out.println(mid);
        System.out.println(ob.delMid(s, mid));
    }
}
