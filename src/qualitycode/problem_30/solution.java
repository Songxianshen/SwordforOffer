package qualitycode.problem_30;


import java.util.Stack;

public class solution {

    static class MinInStack{
        private Stack<Integer> dataStack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>();

        public void push(int item){
            dataStack.push(item);
            if (minStack.isEmpty()){
                minStack.push(item);
            }else {
                if (minStack.peek() > item){
                    minStack.push(item);
                }
            }
        }

        public void pop(){
            if (dataStack.pop() == minStack.peek()){
                minStack.pop();
            }
        }

        public int min(){
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinInStack minInStack = new MinInStack();
        int[] array = {7,8,6,6,87,9,7,7,2,5,7,8,9,5};
        for (int i=0;i<array.length;i++){
            minInStack.push(array[i]);
        }
        System.out.println(minInStack.min());
        for (int i=0;i<array.length-2;i++){
            minInStack.pop();
        }
    }



}
