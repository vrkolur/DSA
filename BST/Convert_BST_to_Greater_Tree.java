package Trees.BST;

public class Convert_BST_to_Greater_Tree {
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

    int sum = 0;

    public void reverseInorder(TreeNode root) {
        if (root == null)
            return;
        reverseInorder(root.right);
        root.data = root.data + sum;
        sum = root.data;
        reverseInorder(root.left);
    }
    
    public void preoder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preoder(root.left);
        preoder(root.right);
    }

    public static void main(String[] args) {
        Convert_BST_to_Greater_Tree ob = new Convert_BST_to_Greater_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        ob.reverseInorder(root);
        ob.preoder(root);
    }   
}
