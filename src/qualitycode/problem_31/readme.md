<link href="markdown.css" rel="stylesheet"></link>

## 从上到下打印二叉树
> 题目1：不分行从上到下打印二叉树  
 
从上到下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印。  
这道题考察二叉树的层序遍历；

> 解题思路： 

从上打印二叉树的规律：
1. 每次打印一个节点的时候，如果该节点有子节点，则把该节点的子节点放到一个队列的末尾。
2. 接下来到队列的头部取出最早进入队列的节点，重复前面的打印操作，直至队列中所有的节点都被打印出来。
```java
/*
class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
*/
public class solution {
    public static void printFromTopToBottom(TreeNode root){
        if (root == null) System.out.println("树为空");
        // 利用链表生成队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
    }
}

```
> 题目2：分行从上到下打印二叉树  
 
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印一行。

> 解题思路： 

这道题与前面的题类似，也可以用一个队列来保存将要打印的节点。为了把二叉树的每一行单独打印到一行里，我们需要两格变量：  
1. 一个变量表示在当前层中还没有打印的节点数； 
2. 另一个变量表示下一层节点的数目。
参考代码如下： 
```java
/*
class TreeNode{
    TreeNode left = null;
    TreeNode right = null;
    int val;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
*/
public class solution {
    public static void printTreeInLine(TreeNode root){
        if (root==null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        TreeNode node;
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.addLast(node.left);
                nextLevel++;
            }
            if (node.right != null){
                queue.addLast(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0){
                System.out.print("\n");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
```