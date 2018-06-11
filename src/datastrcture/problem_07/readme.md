<link href="markdown.css" rel="stylesheet"></link>

## 重建二叉树
**题目：重建二叉树**    

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
<center class="half">
    <img src="../../images/preoblem_7.png" width="40%" height="40%">
</center>

**解题思路：**    


```java
public class solution {
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


