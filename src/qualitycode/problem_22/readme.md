<link href="markdown.css" rel="stylesheet"></link>

## 链表中倒数第 k 个节点
题目:  
输入一个链表，输出该链表倒数第k的节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个节点。  
例如：一个链表有6个节点，从头结点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第三个节点是值为4的节点。  
**解题思路：**    


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
        ListNode aheadNode = listHead;
        ListNode behindNode =  null;
        for (int i=0;i<k-1;i++){
            aheadNode = aheadNode.next;
        }
        behindNode = listHead;
        while (aheadNode.next != null){
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
    }
    public static void main(String[] args) {
        ListNode listHead = createLinkedList(new int[]{1,2,3,4,5,6,7});
        System.out.println(findKtoTail(listHead,2).val);

    }
}
```