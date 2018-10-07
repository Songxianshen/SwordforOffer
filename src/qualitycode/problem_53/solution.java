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
    public static void main(String[] args){

    }
}
