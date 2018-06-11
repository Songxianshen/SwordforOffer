package datastrcture.problem_07;

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
}
