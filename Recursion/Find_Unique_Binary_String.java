package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
// import java.util.List;

public class Find_Unique_Binary_String {
    int flag = 0;

    private void solve(HashSet<String> set, String newString, ArrayList<String> res) {

        if (newString.length() == 3) {
            if (!set.contains(newString)) {
                res.add(newString);
                flag++;
            }
            return;
        }
        if (flag < 1) {
            solve(set, newString + '0', res);
            solve(set, newString + '1', res);
        }
    }

    public static void main(String[] args) {
        Find_Unique_Binary_String ob = new Find_Unique_Binary_String();
        String[] arr = { "000", "001", "010", "111" };
        HashSet<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        ob.solve(set, "", res);
        System.out.println(res.get(0));
        // System.out.println(res);
    }
}
