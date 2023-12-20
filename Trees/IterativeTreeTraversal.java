package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class IterativeTreeTraversal {
    
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode buildLevelOrder(int nodes[], int i) {
        TreeNode root = null;

        if (i < nodes.length) {
            root = new TreeNode(nodes[i]);
            root.left = buildLevelOrder(nodes, i * 2 + 1);
            root.right = buildLevelOrder(nodes, i * 2 + 2);
        }
        return root;
    }

    // First right then left
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.add(root.data);
            if (root.right != null)
                s.push(root.right);
            if (root.left != null)
                s.push(root.left);
        }
        return res;
    }
    
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode currNode = root;
        while (true) {
            if (currNode != null) {
                s.push(currNode);
                currNode = currNode.left;
            } else {
                if (s.isEmpty())
                    break;
                currNode = s.pop();
                res.add(currNode.data);
                currNode = currNode.right;
            }
        }
        return res;
    }


    // First left then right
    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> s = new Stack<>();
        TreeNode currNode = root;
        s.push(currNode);
        while (!s.isEmpty()) {
            currNode = s.pop();
            res.add(currNode.data);
            if (currNode.left != null)
                s.push(currNode.left);
            if (currNode.right != null)
                s.push(currNode.right);
        }
        Collections.reverse(res);
        return res;
    }

    //We need a Queue
    private List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            // TreeNode currNode = q.poll();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode currNode = q.poll();
                level.add(currNode.data);
                if (currNode.left != null)
                    q.offer(currNode.left);
                if (currNode.right != null)
                    q.offer(currNode.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        IterativeTreeTraversal ob = new IterativeTreeTraversal();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        System.out.println(ob.preorder(root));
        System.out.println(ob.inorder(root));
        System.out.println(ob.postorder(root));
        System.out.println(ob.levelorder(root));
        System.gc();
    }
}
