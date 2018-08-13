package others;

public class Sort {
    public static void quickSort(int[] array, int left, int right){
        int l = left;
        int r = right;
        int povit = array[left];
        while (l < r){
            while (l < r && array[r] >= povit) r--;
            if (l < r){
                int temp = array[r];
                array[r] = array[l];
                array[l] = temp;
                l++; }
            while (l < r && array[l] <= povit) l++;
            if (l < r){
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                r--;}}
        if (l > left) quickSort(array, left, l-1);
        if (r < right) quickSort(array, l+1, right);
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,4,3,2,1,23,4,5,6,7};
        quickSort(array, 0, array.length-1);
        for (int item:array){
            System.out.print(item + " ");
        }
    }
}

