package sorts;

public class Sort {
    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high){
        int l = low;
        int h = high;
        int pivot = arr[l]; //枢纽
        while (l < h){
            while (l < h && arr[h] > pivot) h--;
            if (l < h){
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }
            while (l < h && arr[l] < pivot) l++;
            if (l < h){
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        if (low < l) quickSort(arr, low,l-1);
        if (high > h) quickSort(arr, l+1,high);
    }


}

