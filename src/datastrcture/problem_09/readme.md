<link href="markdown.css" rel="stylesheet"></link>

## 用两个栈实现队列

用两个栈实现一个队列 

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入节点和在队列头部
删除节点的功能。

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
 ```java
public class solution {
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        if(pNode == null){
            return null;
        }
        // 当前节点有右节点
        if(pNode.right != null){
            TreeLinkNode p = pNode.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        // 当前节点没有右节点
        }else{
            // 判断是否为根节点
            if(pNode.father == null){
                return null;
            }
            // 判断是否为父节点的左孩子
            while (pNode.father != null){
                if(pNode.father.left == pNode){
                    return pNode.father;
                }
                pNode = pNode.father;
            }
            return null;
        }
    }
}
```