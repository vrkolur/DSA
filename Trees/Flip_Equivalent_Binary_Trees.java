package Trees;


public class Flip_Equivalent_Binary_Trees {

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
            if (nodes[i] == -1)
                return null;
            else
                root = new TreeNode(nodes[i]);
            root.left = buildLevelOrder(nodes, 2 * i + 1);
            root.right = buildLevelOrder(nodes, 2 * i + 2);
        }
        return root;
    }

    public boolean filpEquivalent(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;
        if (r1.data != r2.data)
            return false;

        // if (filpEquivalent(r1.left, r2.left) && filpEquivalent(r1.right, r2.right))
        //     return true;
        // else if (filpEquivalent(r1.left, r2.right) && filpEquivalent(r1.right, r2.left))
        //     return true;
        // else
        //     return false;

        return (filpEquivalent(r1.left, r2.left) && filpEquivalent(r1.right, r2.right)
                || filpEquivalent(r1.left, r2.right) && filpEquivalent(r1.right, r2.left));
    }

    public static void main(String[] args) {
        Flip_Equivalent_Binary_Trees ob = new Flip_Equivalent_Binary_Trees();
        int nodes1[] = { 1, 2, 3, 4, 5, 6, -1, -1, -1, 7, 8 };
        int nodes2[] = { 1, 3, 2, -1, 6, 4, 5, -1, -1, -1, -1, 8, 7 };
        TreeNode root1 = ob.buildLevelOrder(nodes1, 0);
        TreeNode root2 = ob.buildLevelOrder(nodes2, 0);
        System.out.println(ob.filpEquivalent(root1, root2));
        System.gc();
    }
}
