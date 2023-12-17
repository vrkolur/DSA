package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Check out the LeetCode Problem 120
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m[] = new int[n];
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            m[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                m[j] = Math.min(m[j], m[j + 1]) + cur.get(j);
            }
        }
        return m[0];
    }

    // This is the recursive method
    private int minimum(List<List<Integer>> matrix, int i, int j) {
        if (i == matrix.size() - 1)
            return matrix.get(i).get(j);
        int down = matrix.get(i).get(j) + minimum(matrix, i + 1, j);
        int diagonal = matrix.get(i).get(j) + minimum(matrix, i + 1, j + 1);
        return Math.min(down, diagonal);
    }

    // This is a recursive memoziation approach

    private int minimum(List<List<Integer>> matrix, int i, int j, int[][] t) {
        if (i == matrix.size() - 1)
            return matrix.get(i).get(j);
        if (t[i][j] != -1)
            return t[i][j];
        int down = matrix.get(i).get(j) + minimum(matrix, i + 1, j, t);
        int diagonal = matrix.get(i).get(j) + minimum(matrix, i + 1, j + 1, t);
        return t[i][j] = Math.min(down, diagonal);
    }
    
    // This is the tabulation Approach

    private int minimum(List<List<Integer>> matrix) {
        int n = matrix.size();
        int[][] t = new int[n][n];

        for(int j=0;j<n;j++)
            t[n - 1][j] = matrix.get(n - 1).get(j);
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = matrix.get(i).get(j) + t[i + 1][j];
                int diagonal = matrix.get(i).get(j) + t[i + 1][j + 1];
                t[i][j] = Math.min(down, diagonal);
            }
        }
        return t[0][0];
    }

    // Space optimised

    public static void main(String[] args) {
        Triangle ob = new Triangle();
        List<List<Integer>> traingle = new ArrayList<>();
        // int[][] nums = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        int[][] nums = { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } };
        for (int[] it : nums) {
            List<Integer> level = new ArrayList<>();
            for (int num : it) {
                level.add(num);
            }
            traingle.add(level);
        }
        int[][] t = new int[nums.length][nums.length];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.minimumTotal(traingle));
        System.out.println(ob.minimum(traingle, 0, 0));
        System.out.println(ob.minimum(traingle, 0, 0, t));
        System.out.println(ob.minimum(traingle));
    }
}
