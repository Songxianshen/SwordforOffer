<link href="markdown.css" rel="stylesheet"></link>

## 和为s的两个数字。
> 题目一: 和为s的两个数字
   
输入一个递增序列的数组和一个数字s，在数组中查找两个数，使得它们的和正好
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
   
输入一个正数s，打印出所有和为s的正数序列（至少还有连个数）。  
例如，输入 15，由于 1+2+3+4+5=4+5+6=7+8=15，所以打印出三个连续序列 1\~5、4\~6、7\~8。
> 解题思路：     

和上面一道题类似，我们也考虑用两个数`small`和`big`分别表示序列的最小值和最大值。  
首先把`small`初始化为 1，`big`初始化为 2。如果从`small`和`big`的序列的和大于s，则可以从序列中去掉较小的值，也就是增大`small`的值。  
如果从`small`到`big`的序列的和小于 s ，则可以增大`big`，让这个序列包含更多的数字，我们一直增加`small`到(1 + s) / 2为止。
```java
public static void findContinuousSequence(int sum){
    if (sum < 3)
        return;
    int small = 1;
    int big = 2;
    int middle = (1 + sum) / 2;
    int curSum = small + big;
    while (small < middle){
        if (curSum == sum){
            printContinuoutSequence(small, big);
        }
        while (curSum > sum && small < middle){
            curSum -= small;
            small++;
            if (curSum == sum){
                printContinuoutSequence(small, big);
            }
        }
        big++;
        curSum += big;
    }
}

public static void printContinuoutSequence(int small, int big){
    for (int i = small; i <= big; i++){
        System.out.print(i + ' ');
    }
    System.out.print('\n');
}
```



