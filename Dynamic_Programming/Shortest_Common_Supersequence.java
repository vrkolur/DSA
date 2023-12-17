package Dynamic_Programming;


public class Shortest_Common_Supersequence {

    private String supersequence(String s1, String s2) {
        char[] lcs = subsequence(s1, s2).toCharArray();
        int i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        for (char c : lcs) {
            while (s1.charAt(i) != c)
                res.append(s1.charAt(i++));
            while (s2.charAt(j) != c)
                res.append(s2.charAt(j++));
            res.append(c);
            i++;
            j++;
        }
        res.append(s1.substring(i));
        res.append(s2.substring(j));
        return res.toString();
    }

    private String subsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        // System.out.println(t[m][n]);

        StringBuilder sb = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else if (t[i - 1][j] > t[i][j - 1])
                i--;
            else
                j--;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Shortest_Common_Supersequence ob = new Shortest_Common_Supersequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(ob.supersequence(s1, s2));
    }
}
