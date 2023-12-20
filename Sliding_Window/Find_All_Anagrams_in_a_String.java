package Sliding_Window;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String {

    private List<Integer> solution(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() == 0 || s == null)
            return res;

        int[] char_count = new int[26];

        for (char c : p.toCharArray()) {
            char_count[c - 'a']++;
        }

        int l = 0, r = 0;
        int count = p.length();

        while (r < s.length()) {
            if (char_count[s.charAt(r++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0)
                res.add(l);
            if (r - l == p.length() && char_count[s.charAt(l++) - 'a']++ >= 0) {
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Find_All_Anagrams_in_a_String ob = new Find_All_Anagrams_in_a_String();

        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(ob.solution(s, p));
    }
}
