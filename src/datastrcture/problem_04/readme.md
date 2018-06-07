<link href="markdown.css" rel="stylesheet"></link>

## 二维数组中的查找
**题目：二维数组中的查找**    

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。  
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。  
  
例如下面的二维数组就是每行、每列的递增排序。如果在这个数组中查找数字7，则返回true；  
如果查找数字5，由于数组不含有该数字，则返回false。
```
1   2   8   9
2   4   9   12
4   7   10  13
6   8   11  15
```
**解题思路：**  
解决一个复杂的问题时，有效的办法就是从一个具体的问题入手，通过分析简单具体的例子，试图寻找普遍的规律。  
我们选择从数组的一个角上选取数字来和要查找的数字进行比较，情况会简单点。
首先我们选取数组右上角的数字9。由于9大于7，并且9还是第四列的第一个（也是最小的）数字，因此7不可能出现在数字9出现的列。  
于是，我们就可以把这一列剔除了，此时矩阵变为：
```
1   2   8   
2   4   9   
4   7   10  
6   8   11  
```
在剩下的矩阵中，位于右上角的数字为8。同理，8也是大于7，因此9所在的列也应该剔除，此时矩阵为：
```
1   2      
2   4      
4   7     
6   8   
```
在剩余两列的数组中，数字2位于数组的右上角，2小于7，那么要查找的7可能再2的右边，也可能在2的下边。  
但2右边的列已经被我们剔除了，也就是说7只能出现在2的下面，于是我们把数字2所在的行也剔除，此时数组为：
```
2   4      
4   7     
6   8   
```
同理剔除4所在的行，最终得到的数组右上角就是我们要查找的数字7！
```  
4   7     
6   8   
```
**总结规律：** 
1. 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束。
2. 如果该数字大于要查找的数字，则剔除这个数字所在的列；
3. 如果改数字小于要查找的数字，则剔除这个数字所在的行；
4. 这样每一步都可以缩小查找的范围，知道找到要查找的数字，或者查找的范围为空。

分析清楚了，然后写代码就很容易啦


