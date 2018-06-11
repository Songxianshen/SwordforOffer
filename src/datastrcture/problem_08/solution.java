package datastrcture.problem_08;

import utils.TreeNode;

import java.util.Arrays;


public class solution {
    /**
     * 通过前序遍历数组和中序遍历数组来构建二叉树。
     * @param pre 前序遍历数组
     * @param in 中序遍历数组
     * @return 要得到的二叉树
     */
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in){

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

        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0; i < pre.length; i++){
             if (pre[0] == in[i]){
                 root.left = reConstructBinaryTree(
                         Arrays.copyOfRange(pre, 1, i+1),
                         Arrays.copyOfRange(in, 0, i)
                 );
                 root.right = reConstructBinaryTree(
                         Arrays.copyOfRange(pre, i+1, pre.length),
                         Arrays.copyOfRange(in, i+1, in.length)
                 );
             }
        }
        return root;
    }

    public static void main(String[] args) {
        int [] pre = {1, 2, 4, 7, 3, 5, 6 ,8};
        int [] in  = {4, 7 ,2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(pre, in);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println("验证成功");
    }
}
