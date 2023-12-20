package Sliding_Window;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {

    private int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() == (j - i + 1)) {
                maxLen = Math.max(maxLen, (j - i + 1));
                // System.out.println(maxLen);
                j++;
            } else if (map.size() < (j - i + 1)) {
                while (map.size() < (j - i + 1)) {
                    if (map.containsKey(s.charAt(i)))
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }

    private int solution1(String s) {
        int[] lastIndex=new int[180];
        int l=0, largest=0;
        for(int r=0;r<s.length();r++){
            l=Math.max(l,lastIndex[s.charAt(r)]);
            largest=Math.max(r-l+1,largest);
            lastIndex[s.charAt(r)]=r+1;
        }
        return largest;
    }

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters ob = new Longest_Substring_Without_Repeating_Characters();
        String s = "pwwkew";
        System.out.println(ob.solution(s));
        System.out.println(ob.solution1(s));
    }
}
