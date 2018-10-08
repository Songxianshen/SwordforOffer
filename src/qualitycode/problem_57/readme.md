<link href="markdown.css" rel="stylesheet"></link>

## 和为s的两个数字。
> 题目一: 和为s的两个数字
   
&emsp;&emsp; 输入一个递增序列的数组和一个数字s，在数组中查找两个数，使得它们的和正好
是s。如果有多对数字的和等于s，则输出任意一队即可。
> 解题思路：     

```java
public class solution {
    public static List findNumbersWithSum(int[] data, int s){
        int start = 0;
        int end = data.length - 1;
        while (start > end){
            int currentSum = data[start] + data[end];
            if (currentSum == s){
                List<Integer> list = new ArrayList<Integer>();
                list.add(data[start]);
                list.add(data[end]);
                return list;
            }
            else if (currentSum > s)
                start++ ;
            else
                end-- ;
        }
        return null;
    }
}
```



