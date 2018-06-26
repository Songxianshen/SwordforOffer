package qualitycode.problem_22;

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
    public static void main(String[] args) {
        ListNode listHead = createLinkedList(new int[]{1,2,3,4,5,6,7});
        ListNode nodeK = findKtoTail(listHead,2);

    }
}
