package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    public List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtrack(n, 0, 0, res, sb);

        return res;
    }

    public void backtrack(int n, int open, int close, List<String> res, StringBuffer strSoFar) {

        if (strSoFar.length() == 2 * n) {
            res.add(strSoFar.toString());
            return;
        }

        if (open < n) {
            strSoFar.append("(");
            backtrack(n, open + 1, close, res, strSoFar);
            strSoFar.deleteCharAt(strSoFar.length() - 1);
        }

        if (close < open) {
            strSoFar.append(")");
            backtrack(n, open, close + 1, res, strSoFar);
            strSoFar.deleteCharAt(strSoFar.length() - 1);
        }
    }

    public void solution(List<String> output, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            output.add(current);
            return;
        }

        if (open < n)
            solution(output, current + "(", open + 1, close, n);
        if (close < open)
            solution(output, current + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        Generate_Parentheses ob = new Generate_Parentheses();
        List<String> outlist = new ArrayList<>();
        System.out.println(ob.generate(3));
        ob.solution(outlist, "", 0, 0, 3);
        System.out.println(outlist);
    }

}
