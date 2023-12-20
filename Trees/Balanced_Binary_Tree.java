package Trees;

public class Balanced_Binary_Tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode buildLevelOrder(int[] nodes, int i) {
        TreeNode root = null;
        if (i < nodes.length) {
            root = new TreeNode(nodes[i]);

            root.left = buildLevelOrder(nodes, 2 * i + 1);
            root.right = buildLevelOrder(nodes, 2 * i + 2);

        }
        return root;
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        if (lh == -1)
            return -1;

        int rh = height(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }


    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }


    public static void main(String[] args) {
        Balanced_Binary_Tree ob = new Balanced_Binary_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root1 = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.isBalanced(root1));
        System.gc();
    }
}
