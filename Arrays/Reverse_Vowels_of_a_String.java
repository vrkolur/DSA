package Arrays;

import java.util.HashSet;
import java.util.Set;

public class Reverse_Vowels_of_a_String {

    private String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('o');
        set.add('u');
        while (i < j) {
            
        }
    }

    public static void main(String[] args) {
        Reverse_Vowels_of_a_String ob = new Reverse_Vowels_of_a_String();
        String s = "leetcode";

    }
}
