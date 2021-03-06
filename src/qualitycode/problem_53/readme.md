<link href="markdown.css" rel="stylesheet"></link>

## 第一个只出现一次的字符
> 题目一:数字在排序数组中出现的次数。
 
&emsp;&emsp; 统计一个数字在排序数组中出现的次数。例如，输入排序数组
`{1，2，3，3，3，3，4，5}`和数字3，由于3在这个数组中出现了4此，因此输出4.
> 解题思路：     

&emsp;&emsp; 我们先分析如何用二分查找算法在数组中找到第一个`k`。二分查找算法
总是拿数组中间的数字和`k`做比较。如果中间的数字比`k`大，那么`k`只有可能出现在数组
的前半段，下一轮我们只在数据的前半段查找就可以了。如果中间的数字比`k`小，那么`k`
只有可能出现在数组的后半段，下一轮我们只在数组的后半段查找就可以了。如果中间的
数字和`k`相等呢？我们先判断这个数字是不是第一个`k`。如果中间数字的前面一个数字不是
`k`，那么此时中间的数字刚好就是第一个`k`；如果中间数字的前面一个数字也是`k`，那么第一
个`k`肯定在数组的前半段，下一轮我们仍然需要在数组的前半段查找。
```java
public static int getFirstK(int[] data, int length, int k, int start, int end){
    if (start > end) return -1;
    int midIndex = (start + end) / 2;
    int midData = data[midIndex];
    if (midData == k){
        if ((midIndex > 0 && data[midIndex - 1] != k) || midIndex == 0){
            return midIndex;
        }
        else {
            end = midIndex - 1;
        }
    } else if (midData > k){
        end = midIndex - 1;
    } else {
        start = midIndex + 1;
    }
    return getFirstK(data, length, k, start, end);
}
```
&emsp;&emsp;我们可以用同样的思路在排序数组中找到最后一个`k`。如果中间的数字比`k`大，那么
`k`只能出现在数组的前半段。如果中间数字比`k`小，那么`k`只能出现在数组的后半段。如果中间的数字
等于`k`呢？我们需要判断这个`k`是不是最后一个`k`，也就是中间数字的下一个数字是不是也等于`k`。如果
下一个数字不是`k`，则中间数字就是最后一个`k`；否则下一轮我们还是要在数组的后边段去查找。
我们同样可以基于递归写出如下代码：
```java
public static int getLastK(int[] data, int length, int k, int start, int end){
    if (start > end) return -1;
    int midIndex = (start + end) / 2;
    int midData = data[midIndex];
    if (midData == k){
        if ((midIndex < length - 1 && data[midIndex + 1] != k) || midIndex == length-1){
            return midIndex;
        } else {
            start = midIndex + 1;
        }
    } else if (midData < k){
        start = midIndex + 1;
    } else{
        end = midIndex - 1;
    }
    return getLastK(data, length, k, start, end);
}
```
&emsp;&emsp;在分别找到第一个k和最后一个k的下表之后，我们就能计算出k在数组中出现的次数。
相应的代码如下：
```java
public static int getNumbersOfK(int[] data, int length, int k){
    int number = 0;
    if (data != null && length > 0){
        int first = getFirstK(data, length, k, 0, length-1);
        int last = getLastK(data, length, k, 0, length-1);
        if (first > -1 && last > -1)
            number = last - first + 1;
    }
    return number;
}
```
> 题目二: 数组中唯一只出现一次的数字
 
&emsp;&emsp;在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。
请找出那个只出现一次的数字。
> 解题思路： 
    
&emsp;&emsp;我们可以沿用位运算的思路。如果一个数字出现三次，那么它的二进制表示的每一位
（0或者1）也出现三次。如果把所有出现三次的数字的二进制表示的每一位都分别加起来，那么每一
位的和都能被3整除。  
&emsp;&emsp;我们把数组中所有数字的二进制表示的每一位都加起来。如果某一位的和能被3整出，
那么那个只出现一次的数字二进制表示中对应的那一位是0；否则就是1.

```java
public static int findNumberAppearingOnce(int[] numbers){
    int length = numbers.length;
    int[] bitSum = new int[32];
    for (int i=0; i<length; i++){
        int bitMask = 1;
        for (int j=31; j>=0; j--){
            int bit = numbers[i] & bitMask;
            if (bit != 0)
                bitSum[j] += 1;
            bitMask = bitMask << 1;
        }
    }
    int result = 0;
    for (int i = 0; i < 32; i++){
        result = result << 1;
        result += bitSum[i] % 3;
    }
    return result;
}
```