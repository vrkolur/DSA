package Recursion;

public class placeTiles {
    
    public static int solution(int n, int m) {

        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }

        // Vertically
        int vertPlates = solution(n - m, m);

        // Horizontally
        int horiPlates = solution(n - 1, m);

        return vertPlates + horiPlates;
    }
    public static void main(String[] args) {
        int n = 4, m = 2;
        System.out.println(solution(n, m));
    }
}
