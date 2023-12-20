package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;
// import java.util.TreeMap;

public class Bottom_View_Binary_Tree {
    class TreeNode {
        int data;
        int hd;
        TreeNode left, right;

        public TreeNode(int key) {
            this.data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
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

    public void bottomViewTraversal(TreeNode root, List<Integer> res) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        int hd = 0;
        root.hd = 0;

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            hd = temp.hd;
            map.put(hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                q.offer(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                q.offer(temp.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

    }

    public static void main(String[] args) {
        Bottom_View_Binary_Tree ob = new Bottom_View_Binary_Tree();
        int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<Integer> res = new ArrayList<>();
        ob.bottomViewTraversal(root, res);
        System.out.println(res);
        System.gc();
    }

}