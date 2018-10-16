<link href="markdown.css" rel="stylesheet"></link>

## 队列的最大值
> 题目一: 滑动窗口的最大值
   
给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。  
例如，如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小为3，那么一共存在6个滑动窗口，  
他们的最大值分别为{4, 4, 6, 6, 6, 5}，如表所示。  
          
  | 数组中的滑动窗口 | 滑动窗口中的最大值 | 
  | :------: | :------: |
  | [2, 3, 4], 2, 6, 2, 5, 1 | 4 | 
  | 2, [3, 4, 2], 6, 2, 5, 1 | 4 | 
  | 2, 3, [4, 2, 6], 2, 5, 1 | 4 | 
  | 2, 3, 4, [2, 6, 2], 5, 1 | 4 | 
  | 2, 3, 4, 2, [6, 2, 5], 1 | 4 | 
  | 2, 3, 4, 2, 6, [2, 5, 1] | 4 | 

实际上，一个滑动窗口可以看成一个队列。当窗口滑动时，处于窗口的第一个数字被删除，
同时在窗口的末尾添加一个新的数字。这符合队列的“先进先出”特性。如果能从队列中找出
它的最大数，那么这个问题就解决了。
再换一种思路，我们并不把滑动窗口的的每个数值都存入队列，二是只把有可能成为滑动
窗口最大值的数值存入一个两端开口的队列。接着输入数组{2, 3, 4, 2, 6, 2, 5, 1}为例一步一步分析。
  
  
  | 步骤 | 插入数字 | 滑动窗口 | 队列中的下标 | 最大值 |
  | :--- | :--- | :--- | :--- | :--- | 
  | 1 | 2 | 2 | 0(2) | N/A |
  | 2 | 3 | 2, 3 | 1(3) | N/A |
  | 3 | 4 | 2, 3, 4 | 2(4) | 4 |
  | 4 | 2 | 3, 4, 2 | 2(4), 3(2) | 4 |
  | 5 | 6 | 4, 2, 6 | 4(6) | 6 |
  | 6 | 2 | 2, 6, 2 | 4(6), 5(2) | 6 |
  | 7 | 5 | 6, 2, 5 | 4(6), 6(5) | 6 |
  | 8 | 1 | 2, 5, 1 | 6(5), 7(1) | 6 |

  
  
> 解题思路：     


> 题目二: 左旋转字符串
   

> 解题思路：     