package Recursion;

public class callGuest {

    public static int solution(int n) {

        if (n <= 1) {
            return 1;
        }

        // Call Single
        int single = solution(n - 1);

        // Call PairWise
        int pairWise = (n - 1) * solution(n - 2);

        return single + pairWise;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
