package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// import Trees.Balanced_Binary_Tree.node;

public class Top_View_of_Binary_Tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode buildLevelOrder(int[] TreeNodes, int i) {
        TreeNode root = null;
        if (i < TreeNodes.length) {
            if (TreeNodes[i] == -1)
                return null;
            else
                root = new TreeNode(TreeNodes[i]);
            root.left = buildLevelOrder(TreeNodes, 2 * i + 1);
            root.right = buildLevelOrder(TreeNodes, 2 * i + 2);

        }
        return root;
    }

    class Tuple {
        TreeNode node;
        int hd;

        public Tuple(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> topViewTraversal(TreeNode root, List<Integer> res) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> map = new TreeMap<>();
        if (root == null)
            return res;
        else
            q.offer(new Tuple(root, 0));
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            if (!map.containsKey(tuple.hd))
                map.put(tuple.hd, tuple.node);
            if (tuple.node.left != null)
                q.offer(new Tuple(tuple.node.left, tuple.hd - 1));
            if (tuple.node.right != null)
                q.offer(new Tuple(tuple.node.right, tuple.hd + 1));
        }
        for (TreeNode it : map.values()) {
            res.add(it.data);
        }
        return res;
    }

    public static void main(String[] args) {
        Top_View_of_Binary_Tree ob = new Top_View_of_Binary_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<Integer> res = new ArrayList<>();
        ob.topViewTraversal(root, res);
        System.out.println(res);
        System.gc();
    }
}
