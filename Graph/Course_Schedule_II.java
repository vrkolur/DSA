package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_II {
    
    private int[] findOrder(int n, int[][] nodes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int it[] : nodes) {
            adj.get(it[1]).add(it[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        if (q.isEmpty())
            return new int[] {};
        int count = 0;
        int[] res = new int[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            res[count++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        if (count < n)
            return new int[] {};
        else
            return res;
    }

    public static void main(String[] args) {
        Course_Schedule_II ob = new Course_Schedule_II();
        int nodes[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        int n = 4;
        int[] res = ob.findOrder(n, nodes);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
