package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Find_Bottom_Left_Tree_Value {
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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


    public int dfs(TreeNode root) {
        if (root == null)
            return -1;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = -1;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            res = cur.data;
            if (cur.right != null)
                q.offer(cur.right);
            if (cur.left != null)
                q.offer(cur.left);
        }
        return res;
    }

    //The above meathod take a certian amount of time The below solution is bit more optimal

    public void optimaldfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null)
            return;
        if (depth == res.size())
            res.add(root.data);
        optimaldfs(root.left, depth+1, res);
        optimaldfs(root.right, depth+1, res);
    }


    public static void main(String[] args) {
        Find_Bottom_Left_Tree_Value ob = new Find_Bottom_Left_Tree_Value();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<Integer> res = new ArrayList<>();
        ob.optimaldfs(root, 0, res);
        System.out.println(res.get(res.size()-1));
        System.out.println(ob.dfs(root));
    }
}
