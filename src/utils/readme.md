<link href="markdown.css" rel="stylesheet"></link>

## 数据结构节点定义

* 链表
```java
public class ListNode {
    
    public int val;
    public ListNode next = null;

    public ListNode(int val){
        this.val = val;
    }
}
```
* 二叉树
```java
public class TreeNode {
    
    int val;
    TreeNode left;        // 左孩子
    TreeNode right;       // 右孩子
    
    TreeNode(int x){
        this.val = x;
    }
}
```