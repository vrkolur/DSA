package Trees;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Right_Side_View {

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

    public void rightView(TreeNode node, int currDepth, List<Integer> res) {
        if (node == null)
            return;
        if (currDepth == res.size())
            res.add(node.data);
        rightView(node.right, currDepth + 1, res);
        rightView(node.left, currDepth + 1, res);
    }

    public void leftView(TreeNode node, int currDepth, List<Integer> res1) {
        if (node == null)
            return;
        if (currDepth == res1.size())
            res1.add(node.data);
        leftView(node.left, currDepth + 1, res1);
        leftView(node.right, currDepth + 1, res1);
    }

    public static void main(String[] args) {
        Binary_Tree_Right_Side_View ob = new Binary_Tree_Right_Side_View();
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = ob.buildLevelOrder(nodes, 0);
        List<Integer> res=new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();     
        ob.leftView(root, 0, res);
        ob.rightView(root, 0, res1);
        System.out.println(res);
        System.out.println(res1);
        System.gc();
    }
}
