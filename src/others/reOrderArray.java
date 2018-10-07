package others;

public class reOrderArray {
    public static void reOrderArray(int [] array) {
        int length = array.length;
        int p = -1;
        int q = 0;
        while(q < length){
            if((array[q] & 1) == 1){
                p++;
                int res = q;
                int temp = array[q];
                while(p < res){
                    array[res] = array[res-1];
                    res--;
                }
                array[p] = temp;
            }
            q++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        reOrderArray(arr);
        for (int i:arr) System.out.print(i + " ");
    }
}
