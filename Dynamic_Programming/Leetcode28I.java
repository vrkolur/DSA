package Dynamic_Programming;

public class Leetcode28I {
    private int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int idx = 0;
        while (idx < (m - n + 1)) {
            String s = haystack.substring(idx, idx + n);
            if (s.equals(needle))
                return idx;
            idx += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode28I ob = new Leetcode28I();
        String hashstack = "padbutsad";
        String needle = "sad";
        System.out.println(ob.strStr(hashstack, needle));
    }
}
