package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Classic LeetCode Question #2385
public class Amount_of_Time_for_Binary_Tree_to_Be_Infected {
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

    public TreeNode findStart(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root.data == start) {
            return root;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode temp = q.poll();
            for (int i = 0; i < size; i++) {
                if (temp.left != null) {
                    q.offer(temp.left);
                    if (temp.left.data == start) {
                        return temp.left;
                    }
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                    if (temp.right.data == start)
                        return temp.right;
                }
            }
        }
        return null;
    }

    public int timeTaken(TreeNode root,TreeNode start) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        parentTrack(root, parent_track);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(start);
        visited.put(start, true);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
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
            res++;
        }
        return res-1;
    }

    public static void main(String[] args) {
        Amount_of_Time_for_Binary_Tree_to_Be_Infected ob = new Amount_of_Time_for_Binary_Tree_to_Be_Infected();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        TreeNode start = ob.findStart(root, 1);
        int res = ob.timeTaken(root, start);
        System.out.println(res);
        System.gc();
    }
}
