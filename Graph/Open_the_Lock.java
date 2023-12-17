package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Open_the_Lock {

    private int openLock(String[] deadends, String target) {
        Set<String> ends = new HashSet<>();
        for (String s : deadends)
            ends.add(s);
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        vis.add("0000");
        int steps = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int j = 0; j < len; j++) {
                count++;
                String curr = q.poll();
                if (curr.equals(target)) {
                    System.out.println(count);
                    return steps;
                }
                if (ends.contains(curr))
                    continue;
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < 4; i++) {
                    char ch = curr.charAt(i);
                    String s1 = sb.substring(0, i) + (ch == '9' ? '0' : ch - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (ch == '0' ? '9' : ch - '0' - 1) + sb.substring(i + 1);

                    if (!vis.contains(s1)) {
                        vis.add(s1);
                        q.offer(s1);
                    }
                    if (!vis.contains(s2)) {
                        vis.add(s2);
                        q.offer(s2);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Open_the_Lock ob = new Open_the_Lock();
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        System.out.println(ob.openLock(deadends, target));
    }
}
