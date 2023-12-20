package Trees;

public class Count_Complete_Tree_Nodes {
    class TreeNode {
        int data;
        int hd;
        TreeNode left, right;

        public TreeNode(int key) {
            this.data = key;
            hd = Integer.MAX_VALUE;
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

    public int getLH(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int getRH(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int lh = getLH(root);
        int rh = getRH(root);

        if (lh == rh)
            return ((2 << (lh)) - 1);
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        Count_Complete_Tree_Nodes ob = new Count_Complete_Tree_Nodes();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.countNodes(root));
        System.gc();
    }
}
