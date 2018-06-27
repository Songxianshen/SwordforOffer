<link href="markdown.css" rel="stylesheet"></link>

## 树的子结构
> 题目：  

输入两颗二叉树A和B，判断B是不是A的子结构。
二叉树的结构定义如下：
```java
//二叉树结构
class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    
    public BinaryTreeNode(){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```
> 解题思路： 
```java
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
        BinaryTreeNode root1 = reConstructBinaryTree(
                new int[]{8, 8, 9, 2, 4, 7, 7},
                new int[]{9, 8, 4, 2, 7, 8, 7}
                );
        BinaryTreeNode root2 = reConstructBinaryTree(
                new int[]{8, 9, 2},
                new int[]{9, 8, 2}
                );
        //判断树1是否包含树2
        System.out.println(hasSubTree(root1,root2));
    }

}
```
> 输出结果

```
true
```