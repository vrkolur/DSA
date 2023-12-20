package Trees;


public class House_Robber_III {

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
            root.left = buildTree(nodes, i * 2 + 1);
            root.right = buildTree(nodes, i * 2 + 2);
        }
        return root;
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        // int[2]=[0]->withroot [1]->withoutroot.
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int withroot = root.data + left[1] + right[1];
        int withoutroot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[] { withroot, withoutroot };
    }

    public static void main(String[] args) {
        House_Robber_III ob = new House_Robber_III();
        int nodes[]={3,20,10,100,-1,-1,1};
        TreeNode root = ob.buildTree(nodes, 0);
        ob.preorder(root);
        System.out.println();
        int[] res = ob.dfs(root);
        System.out.println(Math.max(res[0], res[1]));
        System.gc();
    }
}
