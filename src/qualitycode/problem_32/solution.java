package qualitycode.problem_32;



import utils.BinaryTree;
import utils.TreeNode;

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
    public static void printFromTopToBottom(TreeNode root){
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
    }

    public static void printTreeInLine(TreeNode root){
        if (root==null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        TreeNode node;
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.addLast(node.left);
                nextLevel++;
            }
            if (node.right != null){
                queue.addLast(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0){
                System.out.print("\n");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }

        }

    }
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(
                new int[]{8,6,5,7,10,9,11},
                new int[]{5,6,7,8,9,10,11}
        );
        System.out.println(binaryTree);
    }
}
