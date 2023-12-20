package Trees.BST;

public class Insert_into_a_Binary_Search_Tree {
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

    public TreeNode insert(TreeNode root, int key) {
        if (root == null)
            return new TreeNode(key);
        TreeNode cur = root;
        while (true) {
            if (cur.data < key) {
                if (cur.right != null)
                    cur = cur.right;
                else {
                    cur.right = new TreeNode(key);
                    break;
                }
            } else {
                if (cur.left != null)
                    cur = cur.left;
                else
                {
                    cur.left = new TreeNode(key);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Insert_into_a_Binary_Search_Tree ob = new Insert_into_a_Binary_Search_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildTree(nodes, 0, nodes.length);
        ob.insert(root, 2);
    }
}
