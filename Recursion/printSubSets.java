package Recursion;

import java.util.ArrayList;

public class printSubSets {
    
    public static void solution(int n, ArrayList<Integer> subset) {
        
        if (n == 0) {
            System.out.println(subset);
            return;
        }

        // will add
        subset.add(n);
        solution(n - 1, subset);
        
        // will not add
        subset.remove(subset.size() - 1);
        solution(n-1, subset);
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        solution(n, subset);

    }
}
