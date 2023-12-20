package Stack_Queue;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

    public int solution(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String t : tokens) {
            if ("+-*/".contains(t))
                s.push(eval(s.pop(), s.pop(), t));
            else
                s.push(Integer.parseInt(t));
        }
        return s.peek();
    }

    public int eval(int b, int a, String op) {
        if ("+".contains(op))
            return a + b;
        else if ("-".contains(op))
            return a - b;
        else if ("*".contains(op))
            return a * b;
        else
            return a / b;
    }

    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation ob = new Evaluate_Reverse_Polish_Notation();
        String[] token = { "2", "1", "+", "3", "*" };
        System.out.println(ob.solution(token));
    }
}
