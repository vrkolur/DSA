package Graph;

import java.util.HashMap;
import java.util.Map;

public class Most_Stones_Removed_with_Same_Row_or_Column {
    

    private int maxRemove(int[][] stones) {
        int num = stones.length;
        int n = 0, m = 0;
        for (int i = 0; i < num; i++) {
            n = Math.max(n, stones[i][0]);
            m = Math.max(m, stones[i][1]);
        }

        DisjointSets ds = new DisjointSets(n + m +1);
        HashMap<Integer, Integer> Nodes = new HashMap<>();

        for (int i = 0; i < num; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + n+1;
            ds.unionbyRank(row, col);
            Nodes.put(row, 1);
            Nodes.put(col, 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> it : Nodes.entrySet()) {
            if (ds.findUltiParent(it.getKey()) == it.getKey())
                count++;
        }
        return num - count;
    }
    public static void main(String[] args) {
        Most_Stones_Removed_with_Same_Row_or_Column ob = new Most_Stones_Removed_with_Same_Row_or_Column();
        // int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        int[][] stones1 = { {0,1},{1,0} };
        System.out.println(ob.maxRemove(stones1));
    }
}
