package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascle_Triangle {

    // Usually there are three types of question;
    // 1.given row and col print the number.
    
    // Watch the pascle triangle problem of Striver.
    private int pascle1(int r, int c) {
        // Simple formuae r-1 C c-1
        int n = 1, d = 1;
        ;
        // Do the simple math idiot
        for (int i = r - 1; i > (r - 1) - (c - 1); i--)
        n *= i;
        for (int i = 1; i < c; i++)
        d *= i;
        return n / d;
    }
    
    // 2.givel number n print the nth column.
    private List<Integer> pascle2(int n) {
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            res.add(ans);
        }
        return res;
    }
    
    // 3. given numRows print the entire triangle.
    // private List<List<Integer>> pascle3(int n) {
        
    // }

    public static void main(String[] args) {
        Pascle_Triangle ob = new Pascle_Triangle();
        // int numRows = 6;
        System.out.println(ob.pascle1(11, 6));
        System.out.println(ob.pascle2(3));
    }
}
