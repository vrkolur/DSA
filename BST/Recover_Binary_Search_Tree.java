package Trees.BST;

public class Recover_Binary_Search_Tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
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

    public TreeNode first;
    public TreeNode prev;
    public TreeNode mid;
    public TreeNode last;

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null && (prev.data > root.data)) {
            // In case we found the first violation we assign first and mid.
            if (first == null) {
                first = prev;
                mid = root;
            } // if we find the second voilation then then assign last to root.
            else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = last = mid = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && mid != null) {
            int temp = first.data;
            first.data = mid.data;
            mid.data = temp;
        }
    }

    public static void main(String[] args) {
        Recover_Binary_Search_Tree ob = new Recover_Binary_Search_Tree();
        int nodes[] = { 1, 2, 3, 4, 6, 5, 7 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        ob.inorderTraversal(root);
        System.out.println();
        ob.recoverTree(root);
        ob.inorderTraversal(root);
        System.gc();
    }
}
