<link href="markdown.css" rel="stylesheet"></link>

## 包含min函数的栈
> 题目：  
 
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小值袁术的min函数。  
在该栈中，调用min,push及pop的时间复杂度都是O(1)。
> 解题思路： 
```java
class MinInStack{
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

```
