package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_of_Binary_Tree {
    
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

    class pair {
        TreeNode node;
        int num;

        pair(TreeNode x,int y){
            node = x;
            num = y;
        }
    }
    public int findWidth(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int currid = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0)
                    first = currid;
                if (i == size - 1)
                    last = currid;
                if (node.left != null)
                    q.offer(new pair(node.left, currid * 2 + 1));
                if (node.right != null)
                    q.offer(new pair(node.right, currid * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Maximum_Width_of_Binary_Tree ob = new Maximum_Width_of_Binary_Tree();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        int width = ob.findWidth(root);
        System.out.println(width);
        System.gc();
    }
}
