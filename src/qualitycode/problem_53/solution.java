package qualitycode.problem_53;



public class solution {
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
    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumbersOfK(arr, arr.length, 3));
    }
}
