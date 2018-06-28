package qualitycode.problem_28;

import java.util.Arrays;


class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return ""+this.val;
    }
}

public class solution {
    /**
     * 判断是否为对称的二叉树
     */
    public static boolean isSymmetrical(BinaryTreeNode root)
    {
        return isSymmetrical(root,root);
    }
    public static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right, root2.left);
    }
    /**
     * 通过前序遍历数组和中序遍历数组来构建二叉树
     */
    public static BinaryTreeNode reConstructBinaryTree(int[] pre, int[] in){
        // 判断三连
        if(pre == null || in == null){
            return null;
        }
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        if(pre.length != in.length){
            return  null;
        }
        BinaryTreeNode root = new BinaryTreeNode(pre[0]);
        for (int i=0;i<pre.length;i++){
            if (pre[0] == in[i]){
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i)
                );
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,i+1,pre.length),
                        Arrays.copyOfRange(in,i+1,in.length)
                );
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // 通过先序和中序遍历构建二叉树
        BinaryTreeNode root = reConstructBinaryTree(
                new int[]{8, 6, 5, 7, 6, 7, 5},
                new int[]{5, 6, 7, 8, 7, 6, 5}
        );
        System.out.println(isSymmetrical(root));
    }

}
