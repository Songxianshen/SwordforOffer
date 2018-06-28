<link href="markdown.css" rel="stylesheet"></link>

## 对称的二叉树
> 题目：  

请实现一个函数，用来判断一颗二叉树是不是对称的。  
如果一颗二叉树和它的镜像一样，那么它是对称的。
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
}
```
