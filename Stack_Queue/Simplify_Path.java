package Stack_Queue;

import java.util.Stack;

public class Simplify_Path {

    public String solution(String str) {
        Stack<String> s = new Stack<>();
        StringBuffer res = new StringBuffer();
        String[] p = str.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!s.isEmpty() && p[i].equals(".."))
                s.pop();
            else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                s.push(p[i]);
        }
        
        if (s.isEmpty())
            return "/";
        while (!s.isEmpty()) {
            res.insert(0, s.pop()).insert(0, "/");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Simplify_Path ob = new Simplify_Path();
        String str = "/../abc//./def/";
        System.out.println(ob.solution(str));
    }
}
