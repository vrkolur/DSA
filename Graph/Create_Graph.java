package Graph;

import java.util.ArrayList;

public class Create_Graph {
    // If it is a directed graph don't add it two way.
    // This is for a Non-Directed Graph,
    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + "-> ");
            for (int j = 0; j < adj.get(i).size(); j++)
                System.out.print(adj.get(i).get(j)+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Create_Graph ob = new Create_Graph();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int v = 5;
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        ob.addEdge(adj, 0, 1);
        ob.addEdge(adj, 0, 4);
        ob.addEdge(adj, 1, 4);
        ob.addEdge(adj, 3, 4);
        ob.addEdge(adj, 1, 3);
        ob.addEdge(adj, 1, 2);
        ob.addEdge(adj, 3, 2);
        ob.printGraph(adj);
    }
}
