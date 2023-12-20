package Recursion;

public class removeDuplicate {

    public static void solution(String str, int idx, boolean[] map) {
        String newString = "";
        if (idx == str.length()) {
            for (int i = 0; i < map.length; i++) {
                if (map[i] == true) {
                    char curr = (char) (i + 'a');
                    newString += curr;
                }
            }
            // System.out.println("Hello");
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == false) {
            map[currChar - 'a'] = true;
            solution(str, idx + 1, map);
        } else {
            solution(str, idx + 1, map);
        }
    }

    public static void main(String[] args) {
        String str = "abbacbcd";
        boolean[] map = new boolean[26];
        solution(str, 0, map);
    }
}
