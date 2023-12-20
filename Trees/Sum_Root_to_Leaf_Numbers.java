package Trees;

public class Sum_Root_to_Leaf_Numbers {
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

    //Sike Problem, get to know the recursive tree from the notebook-2+
    public int findSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.data;
        if (root.left == null && root.right == null)
            return sum;
        return findSum(root.left, sum) + findSum(root.right, sum);
    }

    public static void main(String[] args) {
        Sum_Root_to_Leaf_Numbers ob = new Sum_Root_to_Leaf_Numbers();
        int[] nodes = { 4,9,0,5,1};
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.findSum(root, 0));
    }
}
