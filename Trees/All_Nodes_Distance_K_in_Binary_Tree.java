// package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class All_Nodes_Distance_K_in_Binary_Tree {

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

    public void parentTrack(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.offer(curr.left);
                parent_track.put(curr.left, curr);
            }
            if (curr.right != null) {
                q.offer(curr.right);
                parent_track.put(curr.right, curr);
            }
        }

    }

    public void distance(TreeNode node, TreeNode target, int k, List<Integer> res) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>(); // <child,Parent>
        parentTrack(node, parent_track);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (dis == k)
                break;
            dis++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res.add(curr.data);
        }
    }

    public static void main(String[] args) {
        All_Nodes_Distance_K_in_Binary_Tree ob = new All_Nodes_Distance_K_in_Binary_Tree();
        int nodes[] = { 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4, -1, -1 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<Integer> res = new ArrayList<>();
        ob.distance(root, root.left, 2, res);
        System.out.println(res); 
        System.gc();
    }
}
