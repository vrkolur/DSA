package Stack_Queue;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class carFleet {

    public static int carfleet(int target, int[] pos, int[] speed) {
        Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < pos.length; i++)
            m.put(pos[i], (double) (target - pos[i]) / speed[i]);
        int res = 0;
        double curr = 0.0;
        for (double time : m.values()) {
            if (time > curr) {
                curr = time;
                res++;
            } 
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pos = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        int target = 12;
        System.out.println(carfleet(target, pos, speed));
    }
}
