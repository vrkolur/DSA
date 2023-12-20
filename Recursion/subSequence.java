package Recursion;

import java.util.HashSet;

public class subSequence {

    public static void solution(String str, int idx, String newString) {
        // char currChar = str.charAt(idx);

        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }

        // include the currChar
        solution(str, idx + 1, newString + str.charAt(idx));

        // exclude the currChar
        solution(str, idx + 1, newString);

    }

    public static void solution1(String str, String newString) {

        if (str.length() == 0) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(0);
        String remaningString = str.substring(1);

        // Include the current Char
        solution1(remaningString, newString + currChar);

        // Exclude the currChar

        solution1(remaningString, newString);

    }

    // SubsetProblem with the ASCI value for it

    public static void subsequenceASCI(String str, String newString) {

        if (str.length() == 0) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(0);
        String remaString = str.substring(1);
        int code = currChar;

        // Include currChar
        subsequenceASCI(remaString, newString + currChar);

        // Include the ASCI value
        subsequenceASCI(remaString, newString + Integer.toString(code));

        // Don't include the character
        subsequenceASCI(remaString, newString);
    }

    static String[] keypadarray = { "", "", "abc", "def", "ghi" };

    public static void printCombinations(String str, String newStinrg) {

        if (str.length() == 0) {
            System.out.println(newStinrg);
            return;
        }

        char currChar = str.charAt(0);
        String remString = str.substring(1);
        String code = keypadarray[currChar - '0'];

        for (int i = 0; i < code.length(); i++) {
            printCombinations(remString, newStinrg + code.charAt(i));
        }
    }

    public static void solutionUnique(String str, int idx, String newString, HashSet<String> set) {
        if (idx == str.length()) {
            if (set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        // include the currChar
        solutionUnique(str, idx + 1, newString + str.charAt(idx), set);

        // exclude the currChar
        solutionUnique(str, idx + 1, newString, set);
    }

    public static void main(String[] args) {
        // HashSet<String> set = new HashSet<>();
        String str = "abc";
        solution(str, 0, "");
        // solutionUnique(str, 0, "", set);
        // solution1(str, "");
        // subsequenceASCI(str, "");
        // printCombinations("23", "");
    }
}
