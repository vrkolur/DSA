package Trees.BST;

import java.util.Stack;

public class Binary_Search_Tree_Iterator {
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
    
    Stack<TreeNode> s = new Stack<>();

    public  void BSTIterator(TreeNode root) {
            pushAll(root);
        }

    public int next() {
        TreeNode temp = s.pop();
        pushAll(temp.right);
        return temp.data;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }

    public void pushAll(TreeNode node) {
        while (node != null) {
            s.push(node);
            node = node.left;
        }
    }

    class BSTIterator {

        Stack<TreeNode> s = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode temp = s.pop();
            pushAll(temp.right);
            return temp.data;
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }

        public void pushAll(TreeNode node) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
        }

    }

    public static void main(String[] args) {
        Binary_Search_Tree_Iterator ob = new Binary_Search_Tree_Iterator();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        System.out.println(root.data);
        // BSTIterator ob1 = new BSTIterator(root);
    }
}
