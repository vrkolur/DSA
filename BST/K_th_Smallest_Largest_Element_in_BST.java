package Trees.BST;

public class K_th_Smallest_Largest_Element_in_BST {
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

    // Declaring it inside the class but,outside the method is a instance function.
    int count = 0;
    //This is the inorder travesal, in a inorder traversal of a BST is always in sorted order
    public void kthSmallest(TreeNode root, int k) {
        if (root == null)
            return;
        kthSmallest(root.left, k);
        count++;
        if (count == k)
            System.out.println(root.data);
        kthSmallest(root.right, k);
    }

    int count1 = 0;
    public void kthLargest(TreeNode root, int k) {
        if (root == null)
            return;
        kthLargest(root.right, k);
        count1++;
        if(count1==k) 
            System.out.println(root.data);
        kthLargest(root.left, k);
    }

    public static void main(String[] args) {
        K_th_Smallest_Largest_Element_in_BST ob = new K_th_Smallest_Largest_Element_in_BST();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        // ob.kthSmallest(root, 2);
        ob.kthLargest(root, 10);
        System.gc();
    }
}
