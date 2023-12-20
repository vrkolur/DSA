package Stack_Queue;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    //Lowda Meathod
    static int getMaxArea(int arr[], int n) {

        Stack<Integer> s = new Stack<>();

        int max_area = 0;
        int tp;
        int area;
        int i = 0;

        while (i < arr.length) {
            if (s.empty() || arr[s.peek()] <= arr[i])
                s.push(i++);
            else {
                tp = s.peek();
                s.pop();
                area = arr[tp] * (s.empty() ? i : i - s.peek() - 1);
                // System.out.println(area);
                max_area = Math.max(max_area, area);
            }
        }

        while (!s.isEmpty()) {
            tp = s.peek();
            s.pop();
            area = arr[tp] * (s.empty() ? i : i - s.peek() - 1);
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }

    public static int getMaxArea1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length];
        int[] lessFromRight = new int[height.length];
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

    // Using my Meathod
    public static int solution(int arr[]) {
        int maxarea = 0;
        int n = arr.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.size() == 0) {
                nsr[i] = n;
            } else if (st.size() > 0 && arr[st.peek()] < arr[i]) {
                nsr[i] = st.peek();
            } else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    nsr[i] = n;
                } else {
                    nsr[i] = st.peek();
                }
            }
            st.push(i);
        }
        // for (int i = 0; i < nsr.length; i++) {
        //     System.out.print(nsr[i]+" ");
        // }

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = 0; i < n; i++) {
            if (st.size() == 0) {
                nsl[i] = -1;
            } else if (st.size() > 0 && arr[st.peek()] < arr[i]) {
                nsl[i] = st.peek();
            } else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    nsl[i] = -1;
                } else
                    nsl[i] = st.peek();
            }
            st.push(i);
        }

        // for (int i = 0; i < nsl.length; i++) {
        // System.out.print(nsl[i]+" ");
        // }

        for (int i = 0; i < n;i++){
            maxarea = Math.max(maxarea, arr[i] * (nsr[i] - nsl[i] - 1));
    }

        return maxarea;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(solution(arr));
        // System.out.println(getMaxArea(arr, arr.length));
        // System.out.println(getMaxArea1(arr));
    }
}

/*
 * Similar Questions, Monotonic Stack*
 * 239. Sliding Window Maximum
 * 496. Next Greater Element I
 * 739. Daily Temperatures
 * 862. Shortest Subarray with Sum at Least K
 * 901. Online Stock Span
 * 907. Sum of Subarray Minimums
 * 687. Delivering Boxes from Storage to Ports
 */
