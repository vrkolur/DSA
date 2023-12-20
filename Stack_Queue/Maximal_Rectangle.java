package Stack_Queue;

import java.util.Stack;

public class Maximal_Rectangle {
    public static int solution(int[][] arr) {
        int maxarea = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        int[] arr1 = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1) {
                    arr1[j]++;
                }
                else
                    arr1[j] = 0;
            }
            // for (int j = 0; j < arr1.length; j++) {
            //     System.out.print(arr1[j] + " ");
            // }
            // System.out.println();
            maxarea = Math.max(maxarea, getMaxArea(arr1));
        }
        return maxarea;
    }

    public static int getMaxArea(int[] arr) {

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

    public static void main(String[] args) {
        int arr[][] = { { 1,0,1,0,0 }, { 1,0,1,1,1 }, {1,1,1,1,1 },{1,0,0,0,0} };
        System.out.println(solution(arr));
    }
}

