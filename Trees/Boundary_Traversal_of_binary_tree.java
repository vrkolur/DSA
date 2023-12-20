package Trees;

import java.util.ArrayList;

public class Boundary_Traversal_of_binary_tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode buildLevelOrder(int[] nodes, int i) {
        TreeNode root = null;
        if (i < nodes.length) {
            if (nodes[i] == -1)
                return null;
            else {
                root = new TreeNode(nodes[i]);
                root.left = buildLevelOrder(nodes, 2 * i + 1);
                root.right = buildLevelOrder(nodes, 2 * i + 2);
            }
        }
        return root;
    }

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        else
            return false;
    }

    public void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode currNode = root;
        while (currNode != null) {
            if (!isLeaf(currNode))
                ans.add(currNode.data);
            if (currNode.left != null)
                currNode = currNode.left;
            else
                currNode = currNode.right;
        }
    }

    public void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode currNode = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (currNode != null) {
            if (!isLeaf(currNode))
                temp.add(currNode.data);
            if (currNode.right != null)
                currNode = currNode.right;
            else
                currNode = currNode.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    public void addLeafe(TreeNode root, ArrayList<Integer> ans) {
        if (isLeaf(root))
            ans.add(root.data);
        if (root.left != null)
            addLeafe(root.left, ans);
        if (root.right != null)
            addLeafe(root.right, ans);
    }

    // Another Solution
    ArrayList<Integer> Boundry = new ArrayList<>();

    void leftBoundry(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        } else {
            Boundry.add(root.data);
        }
        if (root.left != null) {
            leftBoundry(root.left);
        } else {
            leftBoundry(root.right);
        }
    }

    void leafNode(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            Boundry.add(root.data);
        }
        leafNode(root.left);
        leafNode(root.right);
    }

    void rightBoundry(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            rightBoundry(root.right);
        } else {
            rightBoundry(root.left);
        }

        if (root.left == null && root.right == null) {
            return;
        } else {
            Boundry.add(root.data);
        }
    }

    public static void main(String[] args) {
        Boundary_Traversal_of_binary_tree ob = new Boundary_Traversal_of_binary_tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        ob.addLeftBoundary(root, ans);
        ob.addLeafe(root, ans);
        ob.addRightBoundary(root, ans);
        System.out.println(ans);
        System.gc();
    }
}
