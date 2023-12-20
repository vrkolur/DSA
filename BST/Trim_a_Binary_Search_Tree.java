package Trees.BST;

public class Trim_a_Binary_Search_Tree {
    class TreeNode {
        int data;
        TreeNode left, right;
        TreeNode(int x) {
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

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public TreeNode trimBST(TreeNode root, int l, int h) {
        if (root == null)
            return null;
        if (root.data > h)
            return trimBST(root.left, l, h);
        if(root.data<l)
            return trimBST(root.right, l, h);
        root.left = trimBST(root.left, l, h);
        root.right = trimBST(root.right, l, h);
        return root;
    }

    public static void main(String[] args) {
        Trim_a_Binary_Search_Tree ob = new Trim_a_Binary_Search_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        TreeNode resRoot = ob.trimBST(root, 3, 4);
        ob.inorder(resRoot);
    }
}
