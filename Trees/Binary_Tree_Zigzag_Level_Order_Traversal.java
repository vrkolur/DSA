package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

    class node {
        int data;
        node left, right;

        node(int x) {
            this.data = x;
            this.left = null;
            this.right = null;
        }
    }

    public node buildTree(int nodes[], int i) {
        node root = null;
        if (i < nodes.length) {
            if (nodes[i] == -1)
                return null;
            else
                root = new node(nodes[i]);

            root.left = buildTree(nodes, i * 2 + 1);
            root.right = buildTree(nodes, i * 2 + 2);
        }
        return root;
    }

    public void spiralTraversal(node root, List<List<Integer>> res) {
        Queue<node> q = new LinkedList<>();
        if (root == null)
            return;
        q.add(root);
        int flag = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                node curr = q.remove();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

                subList.add(curr.data);
            }
            if (flag % 2 == 0) {
                res.add(subList);
            } else {
                Collections.reverse(subList);
                res.add(subList);
            }
            flag++;
        }

    }

    public static void main(String[] args) {
        Binary_Tree_Zigzag_Level_Order_Traversal ob = new Binary_Tree_Zigzag_Level_Order_Traversal();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        node root = ob.buildTree(nodes, 0);
        List<List<Integer>> res = new ArrayList<>();
        ob.spiralTraversal(root, res);
        System.out.println(res);
        System.gc();
    }
}
