package Trees.BST;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

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

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        // This shit runs at O(n) timing.
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;// Here this is the Ans.
    } // Only for binary tree, for a bst we have a more effecient one (lg(n)) time

    public TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        int curVal = root.data;
        if (curVal < p.data && curVal < q.data)
            return lcaBST(root.right, p, q);
        if (curVal > p.data && curVal > q.data)
            return lcaBST(root.left, p, q);
        return root;
    }

    public static void main(String[] args) {
        Lowest_Common_Ancestor_of_a_Binary_Search_Tree ob = new Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        int nodes[] = { 10, 4, 13, 3, 8, 11, 15, 1, 6, 9, 2, 5, 7 }; // Look into notebook for the exact tree.
        TreeNode root = ob.buildLevelOrder(nodes);
        TreeNode p = root.left.left.left;
        TreeNode q = root.left.left.left.right;
        // TreeNode lca = ob.lca(root, p, q);
        TreeNode lca = ob.lcaBST(root, p, q);
        System.out.println(lca.data);
    }
}
