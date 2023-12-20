package Trees;

public class Same_Tree {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            this.data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int[] nodes, int idx) {
        TreeNode root = null;
        if (idx < nodes.length) {
            if (nodes[idx] == -1)
                return null;
            root = new TreeNode(nodes[idx]);
            root.left = buildTree(nodes, idx * 2 + 1);
            root.right = buildTree(nodes, idx * 2 + 2);
        }
        return root;
    }

    private boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return (root1 == root2);
        return (root1.data == root2.data) && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        Same_Tree ob = new Same_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        int nodes1[] = { 1, 2, 3, 4, 5, 6};
        TreeNode root1 = ob.buildTree(nodes, 0);
        TreeNode root2 = ob.buildTree(nodes1, 0);
        System.out.println(ob.sameTree(root1, root2));
    }
}
