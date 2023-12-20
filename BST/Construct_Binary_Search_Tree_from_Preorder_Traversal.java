package Trees.BST;


public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTreePreorder(int nodes[], int bound, int i[]) {
        if (i[0] == nodes.length || nodes[i[0]] > bound)
            return null;
        TreeNode root = new TreeNode(nodes[i[0]++]);
        root.left = buildTreePreorder(nodes, root.data, i);
        root.right = buildTreePreorder(nodes, bound, i);
        return root;
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    
    public static void main(String[] args) {
        Construct_Binary_Search_Tree_from_Preorder_Traversal ob = new Construct_Binary_Search_Tree_from_Preorder_Traversal();
        int preorder[] = { 8, 5, 1, 7, 10, 12 };
        TreeNode root = ob.buildTreePreorder(preorder, Integer.MAX_VALUE, new int[]{0});
        ob.preorderTraversal(root);
    }
}
