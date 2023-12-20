package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {

    private void backtrack(List<String> res, String s, String currIP, int idx, int dots) {
        if (dots == 4 && idx == s.length()) {
            res.add(currIP.substring(0, currIP.length()-1));
            return;
        }
        if (dots > 4)
            return;

        for (int j = idx; j < Math.min(idx + 3, s.length()); j++) {
            int currint = Integer.parseInt(s.substring(idx, j + 1));
            // System.out.println(currint);
            if (currint < 256 && (idx == j || s.charAt(idx) != '0')) {
                backtrack(res, s, currIP + s.substring(idx, j + 1)+ '.', j + 1, dots + 1);
            }
        }
    }

    public static void main(String[] args) {
        Restore_IP_Addresses ob = new Restore_IP_Addresses();
        String s = "25525511135";
        List<String> res = new ArrayList<>();
        ob.backtrack(res, s, "", 0, 0);
        System.out.println(res);
    }
}
