package Stack_Queue;

import java.util.Stack;

public class Remove_K_Digits {

    public String solution(String num, int k) {
        int len = num.length();
        if (k == 0)
            return num;
        if (k == len)
            return "0";

        Stack<Character> s = new Stack<>();
        int index = 0;
        while (index < len) {
            while (k > 0 && !s.isEmpty() && s.peek() > num.charAt(index)) {
                s.pop();
                k--;
            }
            s.push(num.charAt(index++));
        }
        while (k-- > 0)
            s.pop();
        String res = "";
        while (!s.isEmpty())
            res = s.pop() + res;
        // delete leading zeros nigga
        while (res.length() > 1 && res.charAt(0) == '0')
            res = res.substring(1);

        return res;
    }

    public static void main(String[] args) {
        Remove_K_Digits ob = new Remove_K_Digits();
        String num = "1432219";
        int k = 3;
        System.out.println(ob.solution(num, k));
    }
}
