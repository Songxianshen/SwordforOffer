package others;

public class problem13 {
    public static void reOrdArray(int[] array){
        int length = array.length;
        if (length == 0 && length == 1) return;
        int p = -1, q = 0;
        int i, temp;
        while (q < length){
            if ((q & 1) == 0){
                p++;
                i = q;
                temp = array[q];
                while (p < i){
                    array[i] = array[i-1];
                    i--;
                }
                array[p] = temp;
            }
            q++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        reOrdArray(arr);
        for (int i: arr){
            System.out.print(i + " ");
        }
    }
}
