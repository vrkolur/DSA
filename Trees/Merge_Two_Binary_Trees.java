package Trees;

public class Merge_Two_Binary_Trees {
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
            else
                root = new TreeNode(nodes[i]);
            root.left = buildLevelOrder(nodes, 2 * i + 1);
            root.right = buildLevelOrder(nodes, 2 * i + 2);
        }
        return root;
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public TreeNode merge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        TreeNode node = new TreeNode(0);
        if (root1 != null)
            node.data += root1.data;
        if (root2 != null)
            node.data += root2.data;
        node.left = merge(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        node.right = merge(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return node;
    }

    public static void main(String[] args) {
        Merge_Two_Binary_Trees ob = new Merge_Two_Binary_Trees();
        int nodes1[] = { 1, 2, 3, 4, 5, 6, 7 };
        int nodes2[] = { 1, 1, 1, 1, 1, 1, 1 };
        TreeNode root1 = ob.buildLevelOrder(nodes1, 0);
        TreeNode root2 = ob.buildLevelOrder(nodes2, 0);
        TreeNode root = ob.merge(root1, root2);
        ob.preorder(root);
    }
}
