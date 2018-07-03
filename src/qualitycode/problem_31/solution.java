package qualitycode.problem_31;



import utils.BinaryTree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*
class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
*/
public class solution {
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
        return list;
    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(
                new int[]{8,6,5,7,10,9,11},
                new int[]{5,6,7,8,9,10,11}
        );
        BinaryTree binaryTree1 = new BinaryTree();
        System.out.println(binaryTree);
    }
}
