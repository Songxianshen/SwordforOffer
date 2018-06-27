package qualitycode.problem_26;

import java.util.ArrayList;
import java.util.List;

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
        return "该节点的值为:"+this.val;
    }
}

public class solution {
    /**
     * 该方法传入两个树节点分别是root1和root2
     * 判断树2是否为树1的子结构
     */
    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            // 判断根节点是否相等
            if (root1.val == root2.val)
                result = doesTree1haveTree2(root1, root2);
            // 若不相等，则继续判断树一的孩子们和树二的根节点是否相等
            if (!result)
                result = hasSubTree(root1.left, root2);
            if (!result)
                result = hasSubTree(root1.right, root2);
        }
        return result;
    }

    public static boolean doesTree1haveTree2(BinaryTreeNode root1, BinaryTreeNode root2){
        // 检查第二颗树是否为空，如果为空，则包含
        if (root2 == null){
            return true;
        }
        // 第一课树为空，不包含
        if (root1 == null){
            return false;
        }
        // 其相对应的子节点只要不相同，则返回false
        if (root1.val != root2.val){
            return false;
        }
        // 递归该节点所有的孩子
        return doesTree1haveTree2(root1.left,root2.left) && doesTree1haveTree2(root1.right,root2.right);
    }



}
