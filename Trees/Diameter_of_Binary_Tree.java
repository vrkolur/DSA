package Trees;

public class Diameter_of_Binary_Tree {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    // static int idx = -1;

    // public node buildTreePreOrder(int[] nodes) {
    // idx++;
    // if (idx < nodes.length) {
    // if (nodes[idx] == -1)
    // return null;
    // node newNode = new node(nodes[idx]);
    // newNode.left = buildTreePreOrder(nodes);
    // newNode.right = buildTreePreOrder(nodes);

    // return newNode;
    // }
    // return null;
    // }

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

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public int getDiameter(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        int lh = getDiameter(root.left, max);
        int rh = getDiameter(root.right, max);

        max[0] = Math.max(max[0], lh + rh + 1);
        return 1 + Math.max(lh, rh);
    }


    public static void main(String[] args) {
        int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
        // int nodes[] = { 123, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, 7, -1, -1, 8, 9, -1,
        // -1, 10, -1, -1 };
        Diameter_of_Binary_Tree ob = new Diameter_of_Binary_Tree();
        // TreeNode root = ob.buildTreePreOrder(nodes);
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        // System.out.println(ob.maxDepth(root));
        int max[] = new int[1];
        ob.getDiameter(root, max);
        System.out.println(max[0]);
        System.gc();
    }
}
