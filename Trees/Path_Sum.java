package Trees;

public class Path_Sum {
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

    public boolean dfs(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return (root.data == target);
            
        return (dfs(root.left, target - root.data) ||
                dfs(root.right, target - root.data));
    }

    public static void main(String[] args) {
        Path_Sum ob = new Path_Sum();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.dfs(root, 34));
    }
}
