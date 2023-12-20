package Trees.BST;

public class InorderSuccessor_in_BST {
    class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int x) {
            data = x;
            left = right = null;
        }
    }

    public TreeNode buildTree(int[] nodes, int l, int r) {
        if (l > r)
            return null;
        int mid = (r + l) / 2;
        TreeNode node = new TreeNode(nodes[mid]);
        node.left = buildTree(nodes, l, mid - 1);
        node.right = buildTree(nodes, mid + 1, r);
        return node;
    }

    public TreeNode findSuccessor(TreeNode root, TreeNode key) {
        TreeNode res = null;
        while (root != null) {
            if (key.data >= root.data)
                root = root.right;
            else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public TreeNode findPredecessor(TreeNode root, TreeNode key) {
        TreeNode res = null;
        while (root != null) {
            if (root.data >= key.data) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        InorderSuccessor_in_BST ob = new InorderSuccessor_in_BST();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length - 1);
        TreeNode key = root.right;
        System.out.println(key.data);
        TreeNode res = ob.findSuccessor(root, key);
        TreeNode res1 = ob.findPredecessor(root, key);
        System.out.println(res.data);
        System.out.println(res1.data);
    }
}
