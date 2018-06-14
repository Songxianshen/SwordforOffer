<link href="markdown.css" rel="stylesheet"></link>

## 斐波那契数列

求斐波那契数列的第 n 项

写出一个函数，输入 n ，求斐波那契数列的第 n 项。斐波那契数列的定义如下：  
<img src="http://chart.googleapis.com/chart?cht=tx&chl= f(n)={0n=0;1n=1;f(n-1)+f(n-2)" style="border:none;">

<div align=center><img width="600" height="220" src="problem_9_queue.png"/></div>  
  
**解题思路：**  
    
1. 我们通过一个具体的例子来分析往该队列插入和删除元素的过程。首先插入一个元素 a ，不妨先插入 stack1 ，此时 stack1 中的元素有{ a }，
 stack2 为空。再压入两个元素 b 和 c ,还是插入stack1，此时 stack1 中的元素有{ a, b, c}，其中 c 位于栈顶，而 stack2 仍然是空的，如图a
所示。
2. 这时候我们试着在队列中删除一个元素，按照队列先进先出的规则，由于 a 比 b, c 先进入队列，所以最先被删除的元素应该是 a 
。元素 a 存储在 stack1 中，但并不是在栈顶上，因此不能直接被删除。注意到 stack2 一直没有被用过，现在是 stack2 发挥作用的
时候了。如果我们把 stack1 中的元素逐个弹出来并压入 stack2 中，则元素在 stack2 中的顺序与元素在 stack1 中的顺序完全相反。因此经过
三次弹出 stack1 和呀如 stack2 的操作后，stack1 为空，而 stack2 中的元素为{ c, b, a}，这时候就可以弹出 stack2 的栈顶 a 了，此时的 stack1
为空，而 stack2 的元素为{c, b}，如图 b。 
3. 继续删除队列头怎么办？剩下的两个元素是 b 和 c, b 比 c 早进入队列，因此 b 应该先删除。而此时 b 恰好 在栈顶上，所以弹出
stack2 元素的栈顶即可，如图 3。
4. 从上面的分析我们可以总结出删除一个元素的步骤：当stack2不为空时，在stack2中的栈顶元素就是最先进入队列的元素，可以弹出。
当 stack2 为空时，我们把 stack1 中的元素逐个弹出并压入 stack2 。由于先进入队列的元素被压到了 stack1 的低端，经过弹出和压入操作
之后就处于 stack2 的顶端，又可以直接弹出。
5. 接下来插入一个元素 d 。我们还是把它压入 stack1 ，如图 d 所示。我们考虑下一次删除队里的头部 stack2 不为空，直接弹出它的
栈顶元素 c ，如图 e 所示。而 c 的确比 d 先进入队列，应该在 d 之前从队列中删除， 因此不会出现任何矛盾。
 ```java
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

```