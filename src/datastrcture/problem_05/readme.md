<link href="markdown.css" rel="stylesheet"></link>

## 替换空格
**题目：替换空格**    

请实现一个函数，把字符串中的每个空格替换成"%20"。
  
例如，输入“We are happy.”,则输出“We%20are%20happy.”。

**解题思路：**  

**总结规律：** 
1. 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束。
2. 如果该数字大于要查找的数字，则剔除这个数字所在的列；
3. 如果改数字小于要查找的数字，则剔除这个数字所在的行；
4. 这样每一步都可以缩小查找的范围，知道找到要查找的数字，或者查找的范围为空。

分析清楚了，然后写代码就很容易啦

```java
public boolean find(int [][] array, int num){
    if (array == null){
        return false;
    }
    int row = 0;
    int column = array[0].length - 1;
    while(row < array.length && column > 0){
        if(array[row][column] == num){
            return true;
        }
        if(array[row][column] > num){
            column --;
        }else {
            row ++;
        }
    }
    return false;
}
```

