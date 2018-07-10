package qualitycode.problem;


import java.util.ArrayList;

public class solution {
    public static ArrayList<Integer> findNumbersWithSum(int[] arr, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        // 先判断特殊情况：数字小于两个时：
        if (arr.length < 2 || arr == null) return list;
        int start = 0;
        int end = arr.length - 1;
        while (start < end || start < arr.length-1 || end > 0){
            if (arr[start] + arr[end] == sum){
                list.add(arr[start]);
                list.add(arr[end]);
                return list;
            }
            if (arr[start] + arr[end] > sum) end--;
            if (arr[start] + arr[end] < sum) start++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findNumbersWithSum(new int[]{1,2,3,4,5,6,7},5));
    }
}
