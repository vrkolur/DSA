package Trees;

import java.util.Stack;

public class Flatten_Binary_Tree_to_Linked_List {
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

    public void postorder(TreeNode root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    TreeNode prev = null;

    public void flattenRecursive(TreeNode root) {
        if (root == null)
            return;
        flattenRecursive(root.right);
        flattenRecursive(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            if (temp.right != null)
                s.push(temp.right);
            if (temp.left != null)
                s.push(temp.left);
            if (!s.isEmpty())
                temp.right = s.peek();
            temp.left = null;
        }
    }

    // This approach by neetcode, sike method, refer the notes for full explaination of
    // the code.
    public TreeNode flattenNeetcode(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftTail = flattenNeetcode(root.left);
        TreeNode rightTail = flattenNeetcode(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null)
            return rightTail;
        else if (leftTail != null)
            return leftTail;
        else
            return root;
    }

    public static void main(String[] args) {
        Flatten_Binary_Tree_to_Linked_List ob = new Flatten_Binary_Tree_to_Linked_List();
        int nodes[] = { 1, 2, 5, 3, 4, -1, 6, -1, -1, -1, -1, 7 };
        // int nodes1[] = { 3, 4, -1, -1, 5 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);  
        // TreeNode root1 = ob.buildLevelOrder(nodes, 0);
        ob.postorder(root);
        // ob.flattenRecursive(root);
        // ob.flattenIterative(root);
        ob.flattenNeetcode(root);
        System.out.println();
        ob.postorder(root);
        System.gc();
    }
}
