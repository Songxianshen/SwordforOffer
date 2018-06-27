<link href="markdown.css" rel="stylesheet"></link>

## 从尾到头打印链表
> 题目：  

输入一个链表的头结点，从尾到头反过来打印出每个节点的值。链表节点定义如下。
```java
public class ListNode {
    
    public int val;
    public ListNode next = null;
    
    public ListNode(int val){
        this.val = val;
    }
}
```
假设面试官不允许改变原来链表的结构。

> 解题思路：  

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

