package datastrcture.problem_16;

class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }
}

public class solution {

    public ListNode merge(ListNode listNode1, ListNode listNode2){
        if (listNode1 == null)
            return listNode2;
        if (listNode2 == null)
            return listNode1;

        // 定义一个链表作为返回值
        ListNode newListNode = null;
    }



    public static void main(String[] args) {

    }
}
