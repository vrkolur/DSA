package Stack_Queue;

import java.util.Stack;

public class Min_Stack {
    
    Stack<Integer> s = new Stack<>();
    Stack<Integer> ss = new Stack<>();

    public void push(int val) {
        s.push(val);
        if (ss.empty() || ss.peek() >= val) {
            ss.push(val);
        }
    }
    
    public int pop() {
        if (s.size() == 0) {
            return -1;
        }
        int ans = s.peek();
        s.pop();
        if (ss.peek() == ans) {
            ss.pop();
        }
        return ans;
    }

    public int top() {
        if (s.size() == 0) {
            return -1;
        }
        return s.peek();
    }

    public int getMin() {
        if (ss.size() == 0) {
            return -1;
        }
        else {
            return ss.pop();
        }
    }

    public static void main(String[] args) {
       
    }
}
