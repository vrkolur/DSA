package Trees;

import java.util.HashMap;



public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,hm);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie)
            return null;
        TreeNode root = new TreeNode(postorder[pe]);

        int inRoot=hm.get(root.data);
        int numsLeft=inRoot-is;
        root.left = buildTree(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);
        root.right = buildTree(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);
        return root;
    }

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal ob = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        int inorder[] = { 40, 20, 50, 10, 60, 30 };
        int postorder[] = { 40, 50, 20, 60, 30, 10 };
        TreeNode root = ob.buildTree(inorder, postorder);
        System.out.println(root.left.data);
        System.gc();
    }
}
