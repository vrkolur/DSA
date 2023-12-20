package Trees;

public class Maximum_Path_Sum_in_Binary_Tree {

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

    public int findSum(TreeNode root, int[] maxSum) {
        if (root == null)
            return 0;

        int lh = Math.max(0, findSum(root.left, maxSum));
        int rh = Math.max(0, findSum(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], root.data + lh + rh);

        return root.data + Math.max(lh, rh);
    }

    public int findsum(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int lh = Math.max(0, findsum(root.left, max));
        int rh = Math.max(0, findsum(root.right, max));

        max[0] = Math.max(max[0], lh + rh + root.data);

        return root.data + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        int[] nodes = { -10, 9, 20, -1, -1, 15, 7 };
        Maximum_Path_Sum_in_Binary_Tree ob = new Maximum_Path_Sum_in_Binary_Tree();
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        int[] sum = new int[1];
        ob.findSum(root, sum);
        System.out.println(sum[0]);
        System.gc();
    }
}
