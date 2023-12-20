package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node {
    class TreeNode {
        int data;
        TreeNode left, right, next;

        TreeNode(int x) {
            data = x;
            left = right = next = null;
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

    // using extra space.
    public void populate(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.remove();
                if (i == n - 1) {
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                } else {
                    node.next = q.peek();
                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }
            }
        }
    }

    // no Extra Space O(1)
    public TreeNode bfs(TreeNode root) {
        TreeNode cur = root;
        while (cur != null && (cur.left != null) && cur.right != null) {
            TreeNode temp = cur;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            cur = temp.left;
        }
        return root;
    }

    public void traversal(TreeNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Populating_Next_Right_Pointers_in_Each_Node ob = new Populating_Next_Right_Pointers_in_Each_Node();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        // ob.populate(root);
        ob.bfs(root);
        ob.traversal(root.left.left);
        // System.out.println(root.left.next.data);
    }
}
