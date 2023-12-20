package Trees;

public class Subtree_of_Another_Tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;
        if (sameTree(root, subRoot))
            return true;
        return (sameTree(root.left, subRoot) || sameTree(root.right, subRoot));
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root != null && subRoot != null && root.data == subRoot.data)
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        return false;
    }

    public static void main(String[] args) {
        Subtree_of_Another_Tree ob = new Subtree_of_Another_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int nodes1[] = { 45, 46, 342 };
        TreeNode root1 = ob.buildLevelOrder(nodes1, 0);
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        // TreeNode subRoot = root.right;
        System.out.println(ob.isSubtree(root, root1));
    }
}
