package Dynamic_Programming;

public class Longest_Repeating_Subsequence {

    private int longestRepeatingSubsequence(String s1) {
        int n = s1.length();
        int[][] t = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s1.charAt(j - 1) && i != j)
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[n][n];
    }

    public static void main(String[] args) {
        Longest_Repeating_Subsequence ob=new Longest_Repeating_Subsequence();
        String s1 = "AABEBCDD";
        System.out.println(ob.longestRepeatingSubsequence(s1));
        System.gc();
    }
}
