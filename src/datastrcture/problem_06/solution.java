package datastrcture.problem_06;
import java.util.ArrayList;
import java.util.Stack;
import utils.ListNode;


public class solution {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        printListFromTailToHead(l1);
        printListFromTailToHeadRecursively(l1);

    }
}
