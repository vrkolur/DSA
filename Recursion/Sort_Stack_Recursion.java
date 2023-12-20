package Recursion;

import java.util.Stack;

public class Sort_Stack_Recursion {

    public Stack<Integer> sorting(Stack<Integer> s) {
        if (s.size() == 1)
            return s;

        //Induction
        int temp = s.peek();
        s.pop();
        s = sorting(s);
        s = insertion(s, temp);

        return s;
    }
    
    public Stack<Integer> insertion(Stack<Integer> s, int temp) {
        if (s.size() == 0 || s.peek() <= temp) {
            s.push(temp);
            return s;
        }
        //Induction
        int temp1 = s.peek();
        s.pop();
        s = insertion(s, temp);
        s.push(temp1);
        return s;
    }

    public static void main(String[] args) {
        Sort_Stack_Recursion ob = new Sort_Stack_Recursion();
        int[] arr = { 7, 5, 3, 1, 4, 2, 6, 8, 9 };
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
        }
        System.out.println(s);
        ob.sorting(s);
        System.out.println(s);
        // System.out.println(s);
    }
}
