package Trees;

public class Time_Calculator {
    public void test() {
        for (int i = 0; i <= 999999999; i++) {
            for (int j = 0; j < 999999999; j++) {
                for (int k = 0; k < 1; k++) {
                    
                }
            }
        }
    }

    public static void main(String args[]) {
        // Start time
        long begin = System.currentTimeMillis();
        // Starting the watch
        new Time_Calculator().test();
        // End time
        long end = System.currentTimeMillis();

        long time = end - begin;
        System.out.println();
        System.out.println("Elapsed Time: " + time + " milli seconds");
        System.gc();
    }
}