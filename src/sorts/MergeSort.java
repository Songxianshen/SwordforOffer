package sorts;

public class MergeSort {

    public static void sort(int[] arr){
        int[] tmp = new int[arr.length];
        sort(arr, 0, arr.length-1, tmp);
    }

    private static void sort(int[] arr, int left, int right, int[] tmp){
        if (left < right){
            int mid = (left + right)/2;
            sort(arr, left, mid, tmp);
            sort(arr, mid+1,right,tmp);
            merge(arr, left, mid, right, tmp);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right, int[] tmp){
        int i = left;
        int j = mid + 1;
        int t = 0;  //临时数组指针
        while (i <= mid && j <=right){
            if (arr[i] <= arr[j])
                tmp[t++] = arr[i++];
            else
                tmp[t++] = arr[j++];
        }
        while (i<=mid)
            tmp[t++] = arr[i++];
        while (j<=right)
            tmp[t++] = arr[j++];
        t=0;
        while (left <= right){
            arr[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,6,7,2,3,4,2,1,2,3,6,55};
        sort(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}
