package Trees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class Delete_Node_in_a_BST {
    class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int x) {
            data = x;
            left = right = null;
        }
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.data == key)
            return helper(root);
        TreeNode temp = root;

        while (root != null) {
            if (root.data > key) {
                if (root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return temp;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null)
            return root.right;
        else if (root.right == null)
            return root.left;
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public TreeNode findLastRight(TreeNode root) {
        if (root.right == null)
            return root;
        return findLastRight(root.right);
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
        Delete_Node_in_a_BST ob = new Delete_Node_in_a_BST();
        int nodes[] = { 9, 5, 14, 2, 7, 12, 18, 1, 3, 6, 8, 10, 13 };
        TreeNode root = ob.buildLevelOrder(nodes);
        ob.levelorder(root);
        System.out.println();
        TreeNode newroot = ob.deleteNode(root, 9);
        ob.levelorder(newroot);
        System.gc();
    }
}
