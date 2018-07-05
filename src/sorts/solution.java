package sorts;


public class solution{
    public static void quickSort(int[] array, int low, int high){
        int l = low;
        int h = high;
        int povit = array[low];
        while (l<h){
            while (l<h && array[h] >= povit) h--;
            if (l<h){
                int temp = array[h];
                array[h] = array[l];
                array[l] = temp;
                l++;
            }
            while (l<h && array[l] <= povit) l++;
            if (l<h){
                int temp = array[h];
                array[h] = array[l];
                array[l] = temp;
                h--;
            }
        }
        if (l>low) quickSort(array,low,l-1);
        if (h<high) quickSort(array,l+1,high);
    }
}
