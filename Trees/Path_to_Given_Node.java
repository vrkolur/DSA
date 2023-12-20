package Trees;

import java.util.ArrayList;
import java.util.List;

public class Path_to_Given_Node {
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
    public boolean findPath(TreeNode node,int key,List<Integer> res){
        if (node == null)
            return false;
        res.add(node.data);

        if (node.data == key)
            return true;
        
        if (findPath(node.left, key, res) || findPath(node.right, key, res))
            return true;
        
        res.remove(res.size() - 1);

        return false;
    }
    
    public static void main(String[] args) {
        Path_to_Given_Node ob = new Path_to_Given_Node();
        int[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode node = ob.buildLevelOrder(nodes, 0);
        List<Integer> res = new ArrayList<>();
        ob.findPath(node, 7, res);
        System.out.println(res);
        System.gc();
    }
}
