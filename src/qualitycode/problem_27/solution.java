package qualitycode.problem_27;

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
     * 镜像该二叉树
     */
    public static void mirrorRecursively(BinaryTreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
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
                new int[]{8, 8, 9, 2, 4, 7, 7},
                new int[]{9, 8, 4, 2, 7, 8, 7}
        );
        System.out.println(root.left.left);
        mirrorRecursively(root);
        System.out.println(root.right.right);
        mirrorRecursively(null);

        // 测试用例，设该树只有左子树
        BinaryTreeNode root1 = new BinaryTreeNode(0);
        BinaryTreeNode node = root1;
        for(int i=1;i<10;i++){
            node.left = new BinaryTreeNode(i);
            node = node.left;
        }
        mirrorRecursively(root1);
        node = root1;
        for (int i=0;i<10;i++){
            System.out.print(node+"->");
            node = node.right;
        }

    }

}
