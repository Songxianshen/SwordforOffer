<link href="markdown.css" rel="stylesheet"></link>

## 各式各样排序的实现  
1. 快速排序  
基本思想：通过一趟排序将要排序的数组分割成独立的两部分，其中一部分的所有数据都要比另一部分的所有数据小，然后再按此方法对两部分数据
分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序数列。  
算法流程：  
要排序的数组是A[0].....A[N-1]  
a. 设置两个变量 i 和 j ，排序开始的时候：i = 0, j = N-1;   
b. 以第一个数组元素作为关键数据, 赋值给 key , 即key = A[0];  
c. 从 j 开始向前搜索, 即j-- , 找到第一个小于 key 的值 A[j], 将A[j] 和 A[i] 的值互换；  
d. 从 i 开始向后搜索, 即i++ , 找到第一个大于 key 的值 A[i], 将A[i] 和 A[j] 的值互换；  
e. 重复 c-d , 直到 i == j;


```java
/**
 * 快速排序
 * @param array 要排序的数组
 */
public static void quickSort(int [] array, int start, int end){

    if (start > end){
        return;
    }
    int i = start;
    int j = end;
    // 选择第一个数为key
    int key = array[i];

    while(i < j){
        // 从右边往左开始搜索，如果出现比key小的元素，则array[j]与array[i]交换。
        while (i < j && array[j] >= key)
            j--;
        if (array[j] < key){
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        // 从左边往右边开始搜索，如果出现比key大的，则array[i]与array[j]交换。
        while(i < j && array[i] <= key)
            i++;
        if (array[i] > key){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    // 此时key元素的索引就是 i ,key 左边的元素都小于 key，右边的元素都大于 key    
    int keyIndex = i;
    quickSort(array, start, keyIndex-1);
    quickSort(array, keyIndex+1,end);
    }
}
```