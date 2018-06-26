<link href="markdown.css" rel="stylesheet"></link>

## 反转链表
> 题目:
  
定义一个链表，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
> 解题思路：

定义三个指针，分别指向当前遍历到的节点、它的前一个节点以及后一个节点；
```java
class ListNode{
    ListNode next = null;
    int val;

    public ListNode(int val){
        this.val = val;
    }


}

public class solution {
    /**
    * 链表反转
    */
    public static ListNode reverseList(ListNode head){
        ListNode reversehead = null; // 反转头结点
        ListNode node = head;        // 每次遍历的结点
        ListNode prenode = null;
        while (node != null){
            ListNode nextnode = node.next;
            if (nextnode == null)
                reversehead = node;
            node.next = prenode;
            prenode = node;
            node = nextnode;
        }
        return reversehead;
    }
    /**
     * 通过数组创建一个链表
     */
    public static ListNode createLinkedList(int[] array){
        ListNode node = new ListNode(array[0]);
        ListNode head = node;

        for(int i=1;i<array.length;i++){
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    /**
     * 打印一个链表
     */
    public static void printLinkedList(ListNode head){
        if (head == null)
            System.out.println("链表为空；");
        ListNode node = head;
        while (node != null){
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1,2,3,4,5,6,7,8,9,10});
        // 正向打印链表
        printLinkedList(head);
        // 反向打印链表
        printLinkedList(reverseList(head));
    }
}
```
> 输出结果

```
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null
10 -> 9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> null
```

