<link href="markdown.css" rel="stylesheet"></link>

## 链表中倒数第 k 个节点
>题目: 

输入一个链表，输出该链表倒数第k的节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。
例如：一个链表有6个节点，从头结点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第三个节点是值为4的节点。  
> 解题思路：


```java
// 链表定义
class ListNode{
    ListNode next = null;
    int val;

    public ListNode(int val){
        this.val = val;
    }
}

public class solution {
    /**
     * 通过数组创建一个链表
     */
    public static ListNode createLinkedList(int[] array){
        ListNode node = new ListNode(array[0]);
        ListNode root = node;
        
        for(int i=1;i<array.length;i++){
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return root;
    }

    public static ListNode findKtoTail(ListNode listHead,int k){
        
        // 代码的鲁棒性，判断头指针和链表是否为空
        if (listHead == null || k == 0){
            return null;
        }
        
        ListNode aheadNode = listHead;
        ListNode behindNode =  null;
        
        for (int i=0;i<k-1;i++){
            // 判断for循环中防止指向null
            if (aheadNode.next != null)
                aheadNode = aheadNode.next;
            else 
                return null;
        }
        
        behindNode = listHead;
        
        while (aheadNode.next != null){
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        
        return behindNode;
    }
}

```

> 相关题目：

求链表的中间节点。如果链表中的节点总数为奇数，则返回中间节点；如果节点的总数为偶数，则返回中间两个节点的任意一个。为了解决这个问题，
我们定义两个指针，同时从链表的头结点出发，一个指针一次走一步，另一个指针一次走两步。当走的快的指针走到链表的末尾时，走的慢的指针正
好在链表的中间。