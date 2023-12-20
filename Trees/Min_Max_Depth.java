package Trees;

public class Min_Max_Depth {
    class node {
        int data;
        node left, right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public node buildLevelOrder(int[] nodes, int i) {
        node root = null;
        if (i < nodes.length) {
            root = new node(nodes[i]);

            root.left = buildLevelOrder(nodes, 2 * i + 1);
            root.right = buildLevelOrder(nodes, 2 * i + 2);

        }
        return root;
    }

    public int maxDepth(node root) {
        if (root == null)
            return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public int minDepth(node root) {
        if (root == null)
            return 0;

        int lh = minDepth(root.left);
        int rh = minDepth(root.right);

        if (root.left == null && root.right == null)
            return 1;

        if (root.left == null)
            return 1 + rh;

        if (root.right == null)
            return 1 + lh;

        return 1 + Math.min(lh, rh);
    }

    

    public static void main(String[] args) {
        Min_Max_Depth ob = new Min_Max_Depth();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        node root = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.minDepth(root));
        System.out.println(ob.maxDepth(root));
        System.gc();
    }
}
