package datastrcture.problem_09;


import java.util.Stack;

public class solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 在队列尾部插入节点
     * @param node
     */
    public void appendTail(int node){
        //将stack2的元素出栈，进栈道stack2中
        while(!stack2.isEmpty()){
            int x = stack2.pop();
            stack1.push(x);
        }

        //node元素进栈
        stack1.push(node);

        //stack1中全体元素出栈，进入stack1
        while(!stack1.isEmpty()){
            int x = stack1.pop();
            stack2.push(x);
        }
    }

    /**
     * 删除头结点
     * @return
     */
    public int deleteHead(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        solution s = new solution();
        s.appendTail(1);
        s.appendTail(2);
        s.appendTail(3);
        System.out.println(s.deleteHead());
        s.appendTail(4);
        System.out.println(s.deleteHead());
        System.out.println(s.deleteHead());
        System.out.println(s.deleteHead());
    }
}
