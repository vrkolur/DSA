package Trees;

public class Lowest_Common_Ancestor_in_Binary_Tree {

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

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);


        // if either of the one is null return the other   Refer the noteBook for Tree Traverssal
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else //Both are not null
            return root;
    }

    public static void main(String[] args) {
        Lowest_Common_Ancestor_in_Binary_Tree ob = new Lowest_Common_Ancestor_in_Binary_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        TreeNode p   = root.left.left.left;
        TreeNode q = root.left.right.left;
        TreeNode res = ob.lca(root, p, q);
        System.out.println(res.data);
        System.gc();
    }
}
