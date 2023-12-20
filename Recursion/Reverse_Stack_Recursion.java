package Recursion;

import java.util.Stack;

public class Reverse_Stack_Recursion {

    public void reverse(Stack<Integer> s) {
        if (s.size() > 0) {
            int temp = s.peek();
            s.pop();
            reverse(s);
            insertBottom(s, temp);
        }
    }

    public void insertBottom(Stack<Integer> s, int temp) {
        if (s.isEmpty()) {
            s.push(temp);
        } else {
            int temp1 = s.peek();
            s.pop();
            insertBottom(s, temp);
            s.push(temp1);
        }
    }

    public static void main(String[] args) {
        Reverse_Stack_Recursion ob = new Reverse_Stack_Recursion();
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < 6; i++) {
            s.push(i);
        }
        System.out.println(s);
        ob.reverse(s);
        System.out.println(s);
    }
}
