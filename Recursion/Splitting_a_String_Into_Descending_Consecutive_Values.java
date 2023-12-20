// package Recursion;

public class Splitting_a_String_Into_Descending_Consecutive_Values {

    private boolean solve(String s, Long previous) {
        long current = 0;
        for (int i = 0; i < s.length(); i++) {
            current = current * 10 + s.charAt(i) - '0';
            if (previous == null) {
                if (solve(s.substring(i + 1), current))
                    return true;
            } else if (current == previous - 1 && (i == s.length() - 1 || solve(s.substring(i + 1), current)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "321";
        Splitting_a_String_Into_Descending_Consecutive_Values ob = new Splitting_a_String_Into_Descending_Consecutive_Values();
        System.out.println(ob.solve(s, null));
    }
}
