package Trees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class Largest_BST_in_a_Binary_Tree {
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
    // Use as reference fo the bst
    public void levelorder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode currTreeNode = q.remove();
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

    class nodeVal {
        public int minVal, maxVal, maxSize;

        nodeVal(int min, int max, int size) {
            minVal = min;
            maxVal = max;
            maxSize = size;
        }
    }

    public nodeVal findSize(TreeNode root) {
        if (root == null)
            return new nodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        nodeVal left = findSize(root.left);
        nodeVal right = findSize(root.right);

        if (left.maxVal < root.data && root.data < right.minVal)
            return new nodeVal(Math.min(root.data, left.minVal), Math.max(root.data, right.maxVal),
                    left.maxSize + right.maxSize + 1);
        else
            return new nodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static void main(String[] args) {
        Largest_BST_in_a_Binary_Tree ob = new Largest_BST_in_a_Binary_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 ,8,9};
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        // ob.levelorder(root);
        nodeVal res = ob.findSize(root);
        System.out.println(res.maxSize);
    }
}
