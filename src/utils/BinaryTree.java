package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTree {

    /**
     * 二叉树的根节点
     */
    private TreeNode root = null;

    /**
     * 二叉树构造方法
     */
    public BinaryTree(){
        this.root = null;
    }

    /**
     * 通过前序和中序遍历构建二叉树
     * @param pre
     * @param in
     */
    public BinaryTree(int[] pre, int[] in){
        this.root = reConstructBinaryTree(pre, in);
    }

    /**
     * 通过前序和中序遍历来构建二叉树
     * @param pre 前序遍历
     * @param in 中序遍历
     * @return 二叉树根节点
     */
    private TreeNode reConstructBinaryTree(int[] pre, int[] in){
        // 判断三连
        if(pre == null || in == null){
            return null;
        }
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        if(pre.length != in.length){
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0; i < pre.length; i++){
            if (pre[0] == in[i]){
                node.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i+1),
                        Arrays.copyOfRange(in, 0, i)
                );
                node.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i+1, pre.length),
                        Arrays.copyOfRange(in, i+1, in.length)
                );
            }
        }
        return node;
    }

    /**
     * 得到这个树的根节点
     * @return
     */
    public TreeNode getRoot(){
        return root;
    }

    /**
     * 花式方法打印二叉树
     */
    public void printTree(){
        if (this.root != null){
            System.out.print("该树先序遍历结果为: ");
            printPreOrder(this.root);
            System.out.print("\n");

            System.out.print("该树中序遍历结果为: ");
            printInOrder(this.root);
            System.out.print("\n");

            System.out.print("该树层序遍历结果为：");
            printTopToBottom(this.root);
            System.out.print("\n");

            System.out.println("=================================");
            System.out.println("分行从上到下打印二叉树结果为：");
            printTreeInLine(this.root);
            System.out.println("=================================");
        }else{
            System.out.println("该二叉树为空..");
        }

    }

    /**
     * 先序遍历二叉树
     * @param node
     */
    private void printPreOrder(TreeNode node){
            System.out.print(node.val+" ");
            if (node.left != null) printPreOrder(node.left);
            if (node.right != null) printPreOrder(node.right);
    }

    /**
     * 中序遍历二叉树
     * @param node
     */
    private void printInOrder(TreeNode node){
        if (node.left != null) printInOrder(node.left);
        System.out.print(node.val+" ");
        if (node.right != null) printInOrder(node.right);
    }

    /**
     * 层序遍历二叉树
     * @param root
     * @return
     */
    private void printTopToBottom(TreeNode root){
        ArrayList list = new ArrayList();
        if (root == null) {
            System.out.println("该树为空");
        }
        // 利用链表生成一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 队列先进后出
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
        for (Object o:list){
            System.out.print((int)o+" ");
        }
    }

    /**
     * 分行层序遍历二叉树
     * @param root
     */
    private void printTreeInLine(TreeNode root){
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

    /**
     * 重写toString
     * @return
     */
    public String toString() {
        printTree();
        return "";
    }
}
