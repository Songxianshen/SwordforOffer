package qualitycode.problem_24;

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
    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1,2,3,4,5,6,7,8,9,10});
        // 正向打印链表
        printLinkedList(head);
        // 反向打印链表
        printLinkedList(reverseList(head));

    }
}
