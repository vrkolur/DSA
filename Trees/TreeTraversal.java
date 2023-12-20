package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public TreeNode buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1)
            return null;
        TreeNode newTreeNode = new TreeNode(nodes[idx]);
        newTreeNode.left = buildTree(nodes);
        newTreeNode.right = buildTree(nodes);

        return newTreeNode;
    }

    public static void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode currTreeNode = q.poll();
            if (currTreeNode == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            } else {
                System.out.print(currTreeNode.data + " ");
                if (currTreeNode.left != null)
                    q.add(currTreeNode.left);
                if (currTreeNode.right != null)
                    q.add(currTreeNode.right);
            }
        }
    }
    // If we need level order in List<List>> form then this approach

    public static List<List<Integer>> levelorder1(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;

        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode currTreeNode = q.poll();
                ans.add(currTreeNode.data);
                if (currTreeNode.left != null)
                    q.offer(currTreeNode.left);
                if (currTreeNode.right != null)
                    q.offer(currTreeNode.right);
            }
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        // Pass the nodes in the preorder Traversal.
        int nodes[] = { 1, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, 7, -1, -1, 8, 9, -1, -1, 10, -1, -1 };
        TreeTraversal ob = new TreeTraversal();
        TreeNode root = ob.buildTree(nodes);
        // System.out.println(root.data);
        // preorder(root);
        System.out.println();
        // inorder(root);
        // postorder(root);
        levelorder(root);
        // System.out.println(levelorder1(root));
        System.gc();
    }
}
