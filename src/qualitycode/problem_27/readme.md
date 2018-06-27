<link href="markdown.css" rel="stylesheet"></link>

## 二叉树的镜像
> 题目：  

请完成一个函数，输入一颗二叉树，该函数输出它的镜像。
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
}
```
