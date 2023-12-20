package Trees;

public class Check_Children_Sum_Property {
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

    public boolean checkProperty(TreeNode node) {
        int l = 0, r = 0;
        if (node == null || node.left == null && node.right == null)
            return true;
        else {
            if (node.left != null)
                l = node.left.data;
            if (node.right != null)
                r = node.right.data;
            if (node.data == l + r && checkProperty(node.left) && checkProperty(node.right))
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        Check_Children_Sum_Property ob = new Check_Children_Sum_Property();
        int[] nodes = { 40, 10, 30, 3, 7, 12, 18 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.checkProperty(root));
        System.gc();
    }
}
