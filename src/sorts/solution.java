package sorts;

import java.lang.reflect.Array;

public class solution {
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

    public static void main(String[] args) {
        int [] num = { 6, 2, 7, 3, 8, 9};
        quickSort(num,0, num.length-1);
        for (int i:num){
            System.out.println(i);
        }
    }
}
