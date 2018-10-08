package qualitycode.problem_57;


import java.util.ArrayList;
import java.util.List;

public class solution {
    public static List findNumbersWithSum(int[] data, int s){
        int start = 0;
        int end = data.length - 1;
        while (start > end){
            int currentSum = data[start] + data[end];
            if (currentSum == s){
                List<Integer> list = new ArrayList<Integer>();
                list.add(data[start]);
                list.add(data[end]);
                return list;
            }
            else if (currentSum > s)
                start++ ;
            else
                end-- ;
        }
        return null;
    }
}
