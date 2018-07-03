<link href="markdown.css" rel="stylesheet"></link>

## 从上到下打印二叉树
> 题目1：不分行从上到下打印二叉树  
 
从上到下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印。  
这道题考察二叉树的层序遍历；

> 解题思路： 
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
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        // 利用链表生成一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 队列先进先出
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
        return list;
    }
}

```
