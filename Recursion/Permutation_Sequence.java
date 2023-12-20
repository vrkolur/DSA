package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {

    private String solve(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k--;
        while (true) {
            ans = ans + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0)
                break;
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        Permutation_Sequence ob = new Permutation_Sequence();
        System.out.println(ob.solve(4, 17));
    }
}
