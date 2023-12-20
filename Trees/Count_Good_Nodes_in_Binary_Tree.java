package Trees;

public class Count_Good_Nodes_in_Binary_Tree {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int nodes[], int i) {
        TreeNode root = null;
        if (i < nodes.length) {
            if (nodes[i] == -1)
                return null;
            else
                root = new TreeNode(nodes[i]);
            root.left = buildTree(nodes, 2 * i + 1);
            root.right = buildTree(nodes, 2 * i + 2);
        }
        return root;
    }

    int res = 0;

    public int countGoodNodes(TreeNode root, int maxVal) {
        if (root == null)
            return 0;
        if (root.data >= maxVal)
            res = 1;
        else
            res = 0;
        maxVal = Math.max(maxVal, root.data);
        res += countGoodNodes(root.left, maxVal);
        res += countGoodNodes(root.right, maxVal);
        return res;
    }



    public static void main(String[] args) {
        Count_Good_Nodes_in_Binary_Tree ob = new Count_Good_Nodes_in_Binary_Tree();
        int nodes[] = { 3, 1, 4, 3, -1, 1, 5 };
        TreeNode root = ob.buildTree(nodes, 0);
        System.out.println(ob.countGoodNodes(root, 0));
    }
}
