package Trees;

public class Symmetric_Tree {
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

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null || r == null)
            return l == r;

        if (l.data != r.data)
            return false;

        return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }

    public static void main(String[] args) {
        Symmetric_Tree ob = new Symmetric_Tree();
        int nodes[] = { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        if (root == null) {
            System.out.println(true);
        } else
            System.out.println(ob.isSymmetric(root.left, root.right));
        System.gc();
    }
}
