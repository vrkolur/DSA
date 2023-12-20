package Trees;

public class Construct_String_from_Binary_Tree {

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

    public String dfs(TreeNode root) {
        if (root == null)
            return "";
        if (root.right != null)
            return root.data + "(" + dfs(root.left) + ")(" + dfs(root.right) + ")";
        if (root.left != null)
            return root.data + "(" + dfs(root.left) + ")";
        return root.data + "";
    }
    
    public void dfsOptimal(TreeNode root, StringBuilder s) {
        s.append(root.data);
        if (root.left == null && root.right == null)
            return;
        if (root.left == null) {
            s.append("()(");
            dfsOptimal(root.right, s);
            s.append(")");
        }
        else 
        {
            s.append("(");
            dfsOptimal(root.left, s);
            s.append(")");
            if (root.right != null) {
                s.append("(");
                dfsOptimal(root.right, s);
                s.append(")");
            }
        }
    }

    public static void main(String[] args) {
        Construct_String_from_Binary_Tree ob = new Construct_String_from_Binary_Tree();
        int nodes[] = { 1, 2, 3,-1, 4 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        StringBuilder s = new StringBuilder();
        ob.dfsOptimal(root, s);
        System.out.println(s.toString());
        // System.out.println(ob.dfs(root));
    }
}
