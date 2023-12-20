package Trees.BST;

import java.util.ArrayList;
import java.util.List;

public class Two_Sum_IV_Input_is_a_BST {
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

    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static void main(String[] args) {
        Two_Sum_IV_Input_is_a_BST ob = new Two_Sum_IV_Input_is_a_BST();
        int nodes[] = { 2, 3, 4, 5, 6, 7 };
        int key = 9;
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        List<Integer> arr = new ArrayList<>();
        ob.inorder(root, arr);
        int l = 0, r = arr.size() - 1;
        while (l < r) {
            int sum = arr.get(l) + arr.get(r);
            if (sum > key) {
                r--;
            } else if (sum < key) {
                l++;
            } else {
                System.out.println(arr.get(l) + " " + arr.get(r));
                break;
            }
            System.out.println();
        }
    }
}
