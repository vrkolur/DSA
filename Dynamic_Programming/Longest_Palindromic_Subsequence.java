package Dynamic_Programming;

public class Longest_Palindromic_Subsequence {

    private int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        // Now we have to find the Shortest Common Subsequence

        int n = s1.length();
        int[][] t = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[n][n];
    }

    private String printLongestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        // Now we have to find the Shortest Common Subsequence

        int n = s1.length();
        int[][] t = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        int i = n, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (t[i - 1][j] > t[i][j - 1])
                i--;
            else
                j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Longest_Palindromic_Subsequence ob = new Longest_Palindromic_Subsequence();
        String s1 = "aacabdkacaa";
        System.out.println(ob.longestPalindromeSubseq(s1));
        System.out.println(ob.printLongestPalindromeSubseq(s1));
    }
}
