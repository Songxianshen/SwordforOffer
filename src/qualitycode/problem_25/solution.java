package qualitycode.problem_25;

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



    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);


        ListNode newListNode = merge(listNode1,listNode2);
        System.out.println(newListNode.next.val);
        System.out.println(newListNode.next.next.val);
        System.out.println(newListNode.next.next.next.val);
    }
}
