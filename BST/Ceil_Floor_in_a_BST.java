package Trees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class Ceil_Floor_in_a_BST {
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

    public int findCeil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key)
                return root.data;
            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
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

    public int findFloor(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key)
                return root.data;
            if (root.data>key) { 
                floor = root.data;
                System.out.println(root.data);
                root = root.right;
            } else
                root = root.left;
        }
        return floor;
    }

    public static void main(String[] args) {
        Ceil_Floor_in_a_BST ob = new Ceil_Floor_in_a_BST();
        int[] nodes = { 2, 4, 6, 8, 10, 12, 14 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        // System.out.println(ob.findCeil(root, 2));
        System.out.println(ob.findFloor(root, 11));
        // ob.levelorder(root);
        System.gc();
    }
}
