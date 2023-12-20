package Recursion;

import java.util.Arrays;

public class Word_Search {

    static boolean[][] visited;

    private boolean exists(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        visited = new boolean[row][col];

        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board[0].length; j++) {
        // visited[i][j] = false;
        // }
        // }
        for (boolean[] it : visited) {
            Arrays.fill(it, false);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(i, j, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(int r, int c, int idx, char[][] board, String word) {

        if (idx == word.length())
            return true;

        if (r < 0 || r >= board.length ||
                c < 0 || c >= board[0].length ||
                word.charAt(idx) != board[r][c] || visited[r][c])
            return false;

        visited[r][c] = true;

        if (searchWord(r + 1, c, idx + 1, board, word) ||
                searchWord(r - 1, c, idx + 1, board, word) ||
                searchWord(r, c + 1, idx + 1, board, word) ||
                searchWord(r, c - 1, idx + 1, board, word))
            return true;

        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        Word_Search ob = new Word_Search();
        char[][] board = { { 'A', 'B', 'C', 'C' }, { 'A', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(ob.exists(board, "AAA"));
    }
}
