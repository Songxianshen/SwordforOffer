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
> 题目二: 和为s的连续正数序列
   
&emsp;&emsp; 输入一个正数s，打印出所有和为s的正数序列（至少还有连个数）。  
例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出三个连续序列1~5、4~6、7~8
> 解题思路：     



