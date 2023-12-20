package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Convert_Children_Sum_Property {
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

    public void convertTree(TreeNode node) {
        int ld = 0, rd = 0, diff;

        if (node == null || node.left == null && node.right == null) {
            return;
        } else {
            convertTree(node.left);
            convertTree(node.right);

            if (node.left != null)
                ld = node.left.data;
            if (node.right != null)
                rd = node.right.data;

            diff = ld + rd - node.data;

            if (diff > 0)
                node.data = node.data + diff;
            if (diff < 0)
                increament(node, -diff);
        }
    }

    public void increament(TreeNode node, int diff) {
        if (node.left != null) {
            node.left.data = node.left.data + diff;
            increament(node.left, diff);
        } else if (node.right != null) {
            node.right.data = node.right.data + diff;
            increament(node.right, diff);
        }
    }
    // This Algorithm takes O(n^2)
    // Now if we don't have no restriction on the value needs to be minimum as such
    // use the below shit approach.

    public void converTreeOptimal(TreeNode node) {
        if (node == null)
            return;
        int cs = 0;
        if (node.left != null)
            cs += node.left.data;
        if (node.right != null)
            cs += node.right.data;

        if (cs > node.data)
            node.data = cs;
        else if (node.data > cs) {
            if (node.left != null)
                node.left.data = node.data;
            if (node.right != null)
                node.right.data = node.data;
        }
        converTreeOptimal(node.left);
        converTreeOptimal(node.right);

        int total = 0;
        if (node.left != null)
            total += node.left.data;
        if (node.right != null)
            total += node.right.data;
        if (node.left != null || node.right != null)
            node.data = total;
    }

    public static void main(String[] args) {
        Convert_Children_Sum_Property ob = new Convert_Children_Sum_Property();
        int nodes[] = { 50, 7, 2, 3, 5, 1, 30 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        // ob.convertTree(root);
        // ob.levelorder(root);
        ob.converTreeOptimal(root);
        ob.levelorder(root);
        System.gc();
    }
}
