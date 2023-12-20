package Trees;

import java.util.ArrayList;
import java.util.List;

public class Morris_Traversal {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildLevelOrder(int[] TreeNodes, int i) {
        TreeNode root = null;
        if (i < TreeNodes.length) {
            if (TreeNodes[i] == -1)
                return null;
            else
                root = new TreeNode(TreeNodes[i]);
            root.left = buildLevelOrder(TreeNodes, 2 * i + 1);
            root.right = buildLevelOrder(TreeNodes, 2 * i + 2);
        }
        return root;
    }

    public void MorrisInorder(TreeNode root, List<Integer> res) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }
    }

    public void MorrisPreorder(TreeNode root, List<Integer> res) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    res.add(curr.data);
                    curr = curr.left;
                } else {
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Morris_Traversal ob = new Morris_Traversal();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, -1, -1, 8, 9 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<Integer> res = new ArrayList<>();
        // ob.MorrisInorder(root, res);
        ob.MorrisPreorder(root, res);
        System.out.println(res);
        System.gc();
    }
}
