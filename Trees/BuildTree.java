package Trees;

public class BuildTree {

    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // TreeNode root;

    static int idx = -1;

    public TreeNode buildTree(int[] nodes) {
        idx++;
        if (idx < nodes.length) {
            if (nodes[idx] == -1)
                return null;

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        return null;
    }

    public static void main(String[] args) {
        int nodes[] = { 123, 2, 4, -1, -1, 5, 6, -1, -1, -1, 3, 7, -1, -1, 8, 9, -1, -1, 10, -1, -1 };
        // int nodes[] = { 1, 2, -1, -1, 3, -1, 4 };

        BuildTree tree1 = new BuildTree();
        TreeNode root1 = tree1.buildTree(nodes);
        System.out.println(root1.data);
        System.gc();
    }
}
