package Trees;

import java.util.HashMap;
import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] preorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++)
            inMap.put(inorder[i], i);

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,inMap);
        return root;

    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);

        int inroot = inMap.get(root.data);
        int numsLeft = inroot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inroot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inroot + 1, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal ob = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        int[] inorder = { 40, 20, 50, 10, 60, 30 };
        int[] preorder = { 10, 20, 40, 50, 30, 60 };
        TreeNode root = ob.buildTree(inorder, preorder);
        System.out.println(root.left.right.data);
        System.gc();
    }
}
