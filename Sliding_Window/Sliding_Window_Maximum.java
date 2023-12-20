package Sliding_Window;

import java.util.ArrayDeque;
// import java.util.ArrayList;
import java.util.Deque;
// import java.util.List;

public class Sliding_Window_Maximum {

    private int[] solution(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        int resultPointer = 0;

        // store index of arr array
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            // remove index not in k-window
            while (!q.isEmpty() && q.peek() < i - k + 1) // peek() head of queue
                q.poll();
            // remove use-less index in q
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) // peekLast() last of queue
                q.pollLast();
            q.offer(i);
            // start from k-th element, there is a max for window
            if (i >= k - 1)
                result[resultPointer++] = arr[q.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        Sliding_Window_Maximum ob = new Sliding_Window_Maximum();
        int[] arr = { 1, 7, 8, 2, 9, 3, 6, 2 };
        int[] res = ob.solution(arr, 3);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
