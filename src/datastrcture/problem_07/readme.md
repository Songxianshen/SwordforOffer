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
    <img src="datastrcture/problem_07/tree.png " width="60%" height="60%">
</center>

**解题思路：**    

两种解决办法，第一种就是使用栈实现这种顺序。没经过一个节点的时候，把该节点放到一个栈中。
当遍历完整个链表之后，再从栈顶开始逐个输出节点的值，此时输出的顺序已经反过来了。
这种思路的实现代码如下：
```java
public static void printListFromTailToHead(ListNode listNode){
    Stack<Integer> stack = new Stack<Integer>();

    while(listNode != null){
        stack.push(listNode.val);
        listNode = listNode.next;
    }
    while (!stack.isEmpty()){
        System.out.println(stack.pop());
    }
}
```
第二种则是使用递归，递归在本质上就是一个栈结构。要实现反过来输出链表，我们每访问到一个节点的时候，
先递归输出它后面的节点，再输出该节点自身，这样链表的输出结果就反过来了。
```java
public static void printListFromTailToHeadRecursively(ListNode listNode){
    if (listNode != null){
        if (listNode.next != null){
            printListFromTailToHeadRecursively(listNode.next);
            System.out.println(listNode.val);
        }else {
            System.out.println(listNode.val);
        }
    }
}
```

