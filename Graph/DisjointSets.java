package Graph;

import java.util.List;
import java.util.ArrayList;

public class DisjointSets {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSets(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltiParent(int node) {
        if (node == parent.get(node))
            return node;
        int ultp = findUltiParent(parent.get(node));
        parent.set(node, ultp);
        return parent.get(node);
    }

    public void unionbyRank(int u, int v) {
        int pu = findUltiParent(u);
        int pv = findUltiParent(v);
        if (pu == pv)
            return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            int rankU = rank.get(pu);
            rank.set(pu, rankU + 1);
        }
    }

    // Code for UnionBySize.

    public void unionBySize(int u, int v) {
        int pu = findUltiParent(u);
        int pv = findUltiParent(v);

        if (pu == pv)
            return;
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }

    public static void main(String[] args) {
        DisjointSets ob = new DisjointSets(7);
        ob.unionbyRank(1, 2);
        ob.unionbyRank(2, 3);
        ob.unionbyRank(4, 5);
        ob.unionbyRank(6, 7);
        ob.unionbyRank(5, 6);
        if (ob.findUltiParent(1) == ob.findUltiParent(7))
            System.out.println("Yes");
        System.out.println("No");

    }
}
