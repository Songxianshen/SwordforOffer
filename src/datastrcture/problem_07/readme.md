<link href="markdown.css" rel="stylesheet"></link>

## 重建二叉树
>题目 

输入某二叉树的前序遍历和中序遍历结果，请重建二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如，输入的
前序遍历序列为{1， 2， 4， 7， 3， 5， 6， 8}和中序遍历序列{4， 7， 2， 1， 5， 3， 8， 6}，则重建如图所示的二叉树并输出
它的头结点。二叉树节点的定义如下：

```java
public class TreeNode {

    public int val;
    public TreeNode left;        // 左孩子
    public TreeNode right;       // 右孩子

    public TreeNode(int x){
        this.val = x;
    }
}
```
<div align=center><img width="250" height="250" src="../../images/preoblem_7_tree.png"/></div>

> 解题思路

如图所示，前序遍历序列的第一个数字 1 就是根节点的值。扫描中序遍历序列，就能确定根节点的值的位置。根据中序遍历的特点，在根
节点的值 1 前面的 3 个数字都是左子树节点的值，位于 1 后面的数字都是右子树节点的值。  
由于在中序遍历序列中，有 3 个数字是左子树节点的值，因此左子树共有 3 个左子节点。同样，在前序遍历序列中，根节点后面的 3 个
数字就是 3 个左子树节点的值，再后面的所有数字都是右子树节点的值。这样我们就在前序遍历和中序遍历两个序列中分别找到了左、右
子树对应的子序列。 
<div align=center><img width="500" height="250" src="../../images/preoblem_7_array.png"/></div>

```java
public class solution {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in){
        /**
         * 通过前序遍历数组和中序遍历数组来构建二叉树。
         * @param pre 前序遍历数组
         * @param in 中序遍历数组
         * @return 要得到的二叉树
         */
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


