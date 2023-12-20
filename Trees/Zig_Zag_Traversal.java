package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zig_Zag_Traversal {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            this.data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int[] nodes, int idx) {
        TreeNode root = null;
        if (idx < nodes.length) {
            if (nodes[idx] == -1)
                return null;
            root = new TreeNode(nodes[idx]);
            root.left = buildTree(nodes, idx * 2 + 1);
            root.right = buildTree(nodes, idx * 2 + 2);
        }
        return root;
    }

    private List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                level.add(currNode.data);
                if (currNode.left != null)
                    q.offer(currNode.left);
                if (currNode.right != null)
                    q.offer(currNode.right);
            }
            flag = !flag;
            if (flag)
                Collections.reverse(level);
            res.add(level);
        }
        return res;
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Zig_Zag_Traversal ob = new Zig_Zag_Traversal();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildTree(nodes, 0);
        System.out.println(ob.zigzag(root));
        // ob.preorder(root);
    }
}
