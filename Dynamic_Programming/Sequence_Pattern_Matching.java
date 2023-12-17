package Dynamic_Programming;

public class Sequence_Pattern_Matching {

    private boolean patternMatching(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1] + 1;
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        // check only the length is matching not fully, for why see the book.
        return t[m][n] == n;
    }
    
    public static void main(String[] args) {
        Sequence_Pattern_Matching ob = new Sequence_Pattern_Matching();
        String str = "ADXDFCDPSY";
        String pattern = "AXY";
        System.out.println(ob.patternMatching(str, pattern));
    }
}
