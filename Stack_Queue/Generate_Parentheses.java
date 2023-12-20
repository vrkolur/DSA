package Stack_Queue;

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
    
    public static void main(String[] args) {
        Generate_Parentheses ob = new Generate_Parentheses();
        System.out.println(ob.generate(4));
    }

}
