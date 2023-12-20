package Sliding_Window;

// import java.util.Collections;
import java.util.HashMap;

public class Longest_Repeating_Character_Replacement {

    private int solution(String s, int k) {
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int maxfreq = 0;
        for (r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(ch));
            while ((r - l + 1) - maxfreq > k) {
                char ch1 = s.charAt(l);
                map.put(ch1, map.get(ch1) - 1);
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }

    private int solution1(String s, int k) {
        int map[] = new int[26];

        int l = 0, r = 0, maxCount = 0, maxLen = 0;

        for (r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map[c - 'A']++;
            maxCount = Math.max(maxCount, map[c - 'A']);
            while (r - l + 1 - maxCount > k) {
                c = s.charAt(l);
                map[c - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Longest_Repeating_Character_Replacement ob = new Longest_Repeating_Character_Replacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(ob.solution(s, k));
        System.out.println(ob.solution1(s, k));
    }
}
