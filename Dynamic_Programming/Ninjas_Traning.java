package Dynamic_Programming;

import java.util.Arrays;

public class Ninjas_Traning {

    // First the brut Force, full recursion.
    private int train(int day, int last, int[][] task) {
        int maxi = 0, points = 0;
        // if we are at the last day then this(we are doing this from day=n-1)
        if (day == 0) {
            maxi = 0;
            for (int i = 0; i < 3; i++) {
                // Take max of all the tasks here because there is no need to worry of day[-1].
                if (i != last) {
                    maxi = Math.max(maxi, task[0][i]);
                }
            }
            return maxi;
        }
        maxi = 0;
        // suppose we are day!=0
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                // Don't take max of all the tasks in the present day,
                // If so then this becomes greedy and result will wrong.
                points = task[day][i] + train(day - 1, i, task);
            }
            maxi = Math.max(maxi, points);
        }
        return maxi;
    }

    // gt formal
    public  int findMax(int day,int last,int[][] train) {
        int maxi = 0;
        return maxi;
    }

    //Meotisation
    private int train(int day, int last, int[][] task, int[][] t) {
        int maxi = 0, points = 0;
        if (day == 0) {
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, task[0][i]);
                }
            }
            return maxi;
        }
        maxi = 0;
        if (t[day][last] != -1)
            return t[day][last];
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                points = task[day][i] + train(day - 1, i, task, t);
            }
            maxi = Math.max(maxi, points);
        }
        return t[day][last] = maxi;
    }

    // Now the Dynamic Approach

    private int train(int[][] task) {
        int n = task.length;
        int[][] t = new int[n][4];
        // first we will solve for day=0
        t[0][0] = Math.max(task[0][1], task[0][2]);
        t[0][1] = Math.max(task[0][0], task[0][2]);
        t[0][2] = Math.max(task[0][0], task[0][1]);
        // if there is only 1 day then we have to take max os all the tasks
        t[0][3] = Math.max(task[0][0], Math.max(task[0][1], task[0][2]));

        // Now when day becomes 1,2,3,..
        for (int day = 1; day < n; day++) {
            // all the posible valuse of the value last is 0,1,2,3
            // here we will take laast till 4 because of day=n-1 all are required
            for (int last = 0; last < 4; last++) {
                // all the possible values of i
                for (int i = 0; i < 3; i++) {
                    int points = 0;
                    if (i != last) {
                        points = task[day][i] + t[day - 1][i];
                    }
                    t[day][last] = Math.max(points, t[day][i]);
                }
            }
        }
        return t[n - 1][3];
    }

    public static void main(String[] args) {
        Ninjas_Traning ob = new Ninjas_Traning();
        int[][] task = { { 10, 50, 30 }, { 20, 100, 40 }, { 30, 30, 30 } };
        System.out.println(ob.train(task.length - 1, 3, task));
        int[][] t = new int[task.length][4];
        for (int[] it : t) {
            Arrays.fill(it, -1);
        }
        System.out.println(ob.train(task.length - 1, 3, task, t));
        System.out.println(ob.train(task));
        System.gc();
    }
}
