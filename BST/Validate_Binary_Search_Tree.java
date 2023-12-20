package Trees.BST;


public class Validate_Binary_Search_Tree {
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

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.data <= minVal || root.data >= maxVal)
            return false;
        return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
    }

    public static void main(String[] args) {
        Validate_Binary_Search_Tree ob = new Validate_Binary_Search_Tree();
        int nodes[] = { 1, 2, 8, 4, 5, 6, 7 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        System.out.println(ob.isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
