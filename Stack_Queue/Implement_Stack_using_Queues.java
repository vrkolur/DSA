package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Implement_Stack_using_Queues {

    Deque<Integer> q = new ArrayDeque<>();

    public void push(int x) {
        q.push(x);
        return;
    }

    public int pop() {
        if (q.size() == 0)
            return -1;
        for (int i = 0; i < q.size() - 1; i++) {
            push(q.pop());
        }
        return q.pop();
    }

    public int top() {
        return q.peekFirst();
    }

    public boolean empty() {
        return q.size() == 0;
    }

    public static void main(String[] args) {
        // Implement_Stack_using_Queues ob = new Implement_Stack_using_Queues();

    }
}
