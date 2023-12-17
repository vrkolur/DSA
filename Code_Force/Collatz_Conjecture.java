package Code_Force;

public class Collatz_Conjecture {
    
    public static void main(String[] args) {

        // This distrubution is known as Benford's Law
        int n = 27;
        int count = 0;
        while (n > 0 && count<500) {
            if (n % 2 == 1) {
                n = 3 * n + 1;
                count++;
                System.out.println(n);
            } else {
                n = n / 2;
                System.out.println(n);
                count++;
            }
        }
    }
}
