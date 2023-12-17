package Graph;


public class Number_of_Provinces_DisjointSets {

    public int findCircleNum(int[][] nodes, int v) {
        DisjointSets ds = new DisjointSets(v);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (nodes[i][j] == 1 && i != j) {
                    ds.unionbyRank(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (ds.findUltiParent(i) == i)
                count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Number_of_Provinces_DisjointSets ob=new Number_of_Provinces_DisjointSets();
        int[][] nodes = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int v = nodes.length;
        System.out.println(ob.findCircleNum(nodes, v));
    }
}
