package qualitycode.problem_23;

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
     * 如果链表不存在环，那么函数meetingNode返回null
     */
    public static ListNode meetingNode(ListNode head){
        // 判断头是否为空
        if (head == null)
            return null;

        ListNode slow = head.next;
        if (slow == null)
            return null;

        ListNode fast = slow.next;

        while (fast != null && slow != null){
            if (fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    /**
     * 在找到环中任意一个节点之后，就能得出环的节点数目，
     * 并找到环的入口节点。
     */
    public static ListNode entryNodeOfLoop(ListNode head){
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;

        // 得到环中节点的数目
        int nodesInLoop = 1;
        ListNode node1 = meetingNode;
        while (node1.next != meetingNode){
            node1 = node1.next;
            nodesInLoop ++;
        }
        

        return null;
    }

    public static void main(String[] args) {

    }
}
