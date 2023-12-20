package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Vertical_Order_Traversal_of_a_Binary_Tree {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            this.data = x;
            this.left = this.right = null;
        }
    }

    public TreeNode buildLevelOrder(int[] nodes, int i) {
        TreeNode root = null;
        if (i < nodes.length) {
            if (nodes[i] == -1)
                return null;
            else
                root = new TreeNode(nodes[i]);
            root.left = buildLevelOrder(nodes, 2 * i + 1);
            root.right = buildLevelOrder(nodes, 2 * i + 2);
        }
        return root;
    }

    class Tuple {
        TreeNode node;
        int row;
        int col;

        Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }

    public void verticleTraversal(TreeNode root, List<List<Integer>> res) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());

            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());

            map.get(x).get(y).offer(node.data);

            if (node.left != null)
                q.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, x + 1, y + 1));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        Vertical_Order_Traversal_of_a_Binary_Tree ob = new Vertical_Order_Traversal_of_a_Binary_Tree();
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<List<Integer>> res = new ArrayList<>();
        ob.verticleTraversal(root, res);
        System.out.println(res);
        System.gc();
    }
}
