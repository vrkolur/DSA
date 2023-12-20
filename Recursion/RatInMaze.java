package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class RatInMaze {

    // Approach is to find the solution array

    boolean isSafe(int arr[][], int x, int y, int n) {
        if (x < n && y < n && arr[x][y] == 1)
            return true;
        else
            return false;
    }

    boolean inMaze(int[][] arr, int x, int y, int n, int solarr[][]) {

        if (x == n - 1 && y == n - 1) {
            solarr[x][y] = 1;
            return true;
        }

        if (isSafe(arr, x, y, n)) {
            solarr[x][y] = 1;
            if (inMaze(arr, x + 1, y, n, solarr)) {
                return true;
            }
            if (inMaze(arr, x, y + 1, n, solarr)) {
                return true;
            }
            solarr[x][y] = 0; // backtracking
            return false;
        }
        return false;
    }


    // Arrroach 2 Printing DR shit
    static ArrayList<String> res;
    static int[][] visited;

    public static void findPaths(int[][] m, int x, int y, String s, int n) {
        if (x == n - 1 && y == n - 1) {
            res.add(s);
            return;
        } else {
            visited[x][y] = 1;
        }
        if (x + 1 < n && visited[x + 1][y] == 0 && m[x + 1][y] == 1) {
            findPaths(m, x + 1, y, s + "D", n); // down
        }
        // if (y - 1 >= 0 && visited[x][y - 1] == 0 && m[x][y - 1] == 1) {
        //     findPaths(m, x, y - 1, s + "L", n); // LEFT
        // }
        if (y + 1 < n && visited[x][y + 1] == 0 && m[x][y + 1] == 1) {
            findPaths(m, x, y + 1, s + "R", n); // RIGHT
        }
        // if (x - 1 >= 0 && visited[x - 1][y] == 0 && m[x - 1][y] == 1) {
        //     findPaths(m, x - 1, y, s + "U", n); // UP
        // }
        visited[x][y] = 0;
    }

    public ArrayList<String> findPath(int[][] m, int n) {
        visited = new int[n][n];
        res = new ArrayList<>();
        if (m[0][0] == 0) {
            return res;
        }
        String s = "";
        findPaths(m, 0, 0, s, n);
        return res;
    }
    // End of the second solution part.

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        RatInMaze ob = new RatInMaze();
        int n = cin.nextInt();
        int arr[][] = new int[n][n];
        // int solarr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        // if (ob.inMaze(arr, 0, 0, n, solarr)) {
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             System.out.print(solarr[i][j] + " ");
        //         }
        //         System.out.println();
        //     }
        // }
        System.out.println(ob.findPath(arr, n));
        
        cin.close();
    }
}
