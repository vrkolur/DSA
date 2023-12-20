package Sliding_Window;

import java.util.HashMap;

public class Longest_K_unique_characters_substring {

    private int solution(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = Integer.MIN_VALUE;

        while (j < s.length()) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    }
                    if(map.get(s.charAt(i))==0)
                        map.remove(s.charAt(i));
                    i++;
                    // if (map.containsKey(s.charAt(i))) {
                    //     int freq = map.get(s.charAt(i));
                    //     freq--;
                    //     map.put(s.charAt(i), freq);
                    // }
                    // if (map.get(s.charAt(i)) == 0) {
                    //     map.remove(s.charAt(i));
                    // }
                    // i++;
                }
                j++;
            }
        }
        // System.out.println(map);
        return (map.size() < k) ? 0 : maxLen;
    }

    private int solution1(String s, int k) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxStringlen = Integer.MIN_VALUE;
        while (j < s.length()) {
            char ch = s.charAt(j);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

            if (charMap.size() < k) {
                j++;
            } else if (charMap.size() == k) {
                maxStringlen = Math.max(maxStringlen, j - i + 1);
                j++;
            } else if (charMap.size() > k) {
                while (charMap.size() > k) {

                    if (charMap.containsKey(s.charAt(i))) {
                        int freq = charMap.get(s.charAt(i));
                        freq--;
                        charMap.put(s.charAt(i), freq);
                    }
                    if (charMap.get(s.charAt(i)) == 0) {
                        charMap.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        System.out.println("The no of unique chars are : " + charMap.size());
        return (charMap.size() < k) ? 0 : maxStringlen;
    }

    public static void main(String[] args) {
        Longest_K_unique_characters_substring ob = new Longest_K_unique_characters_substring();
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(ob.solution(s, k));
        System.out.println(ob.solution1(s, k));
    }
}
