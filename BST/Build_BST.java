package Trees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class Build_BST {
    class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int[] nodes, int l, int r) {
        if (l > r)
            return null;
        int mid = (r + l) / 2;
        TreeNode node = new TreeNode(nodes[mid]);
        node.left = buildTree(nodes, l, mid - 1);
        node.right = buildTree(nodes, mid + 1, r);
        return node;
    }

    public TreeNode construct(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data)
            root.left = construct(root.left, data);
        else
            root.right = construct(root.right, data);

        return root;
    }

    public TreeNode buildLevelOrder(int[] nodes) {
        if (nodes.length == 0)
            return null;
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = construct(root, nodes[i]);
        }
        return root;
    }

    public void levelorder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Build_BST ob = new Build_BST();
        int[] nodes = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        // TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        TreeNode root = ob.buildLevelOrder(nodes);
        ob.levelorder(root);
        System.gc();
    }
}
