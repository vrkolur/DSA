package Trees;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {
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

    public void dfs(TreeNode root,int target, List<Integer> ans, List<List<Integer>> res) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null && root.data == target) {
            ans.add(root.data);
            res.add(new ArrayList<>(ans));
            ans.remove(ans.size() - 1);
        }
        ans.add(root.data);
        dfs(root.left, target - root.data, ans, res);
        dfs(root.right, target - root.data, ans, res);
        ans.remove(ans.size() - 1);
    }
    
    public static void main(String[] args) {
        Path_Sum_II ob = new Path_Sum_II();
        int nodes[] = { 1, 2, 3, 4, 5, 3, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<List<Integer>> res = new ArrayList<>();
        ob.dfs(root, 7, new ArrayList<>(), res);
        System.out.println(res);
        System.gc();
    }
}
