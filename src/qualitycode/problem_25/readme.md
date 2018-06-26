<link href="markdown.css" rel="stylesheet"></link>

## 合并两个排序的链表
> 题目：  
  
输入两个递增排序的链表，合并这两个链表并使新链表中的节点任然是递增排序的。  
例如，输入图中的链表1和链表2，则合并之后的升序链表如链表3所示。  
> 解题思路： 


```java
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}

public class solution {

    public static ListNode merge(ListNode listNode1, ListNode listNode2){
        if (listNode1 == null)
            return listNode2;
        if (listNode2 == null)
            return listNode1;

        // 定义一个链表作为返回值
        ListNode newListNode = null;

        if (listNode1.val < listNode2.val){
            newListNode = listNode1;
            newListNode.next = merge(listNode1.next, listNode2);
        }else {
            newListNode = listNode2;
            newListNode.next = merge(listNode1, listNode2.next);
        }
        return newListNode;
    }

}
```