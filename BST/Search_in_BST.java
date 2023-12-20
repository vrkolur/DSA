package Trees.BST;

import java.util.LinkedList;
import java.util.Queue;

public class Search_in_BST {
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
    
    public  void levelorder(TreeNode root) {
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

    public boolean search(TreeNode root,int key) {
        if (root == null)
            return false;
        while (root != null) {
            if (root.data == key) {
                return true;
            }
            if (root.data > key)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }

    public static void main(String[] args) {
        Search_in_BST ob = new Search_in_BST();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length-1);
        // System.out.println(ob.search(root, 3));
        ob.levelorder(root);
    }
}
