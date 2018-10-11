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
    public static void findContinuousSequence(int sum){
        if (sum < 3)
            return;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle){
            if (curSum == sum){
                printContinuoutSequence(small, big);
            }
            while (curSum > sum && small < middle){
                curSum -= small;
                small++;
                if (curSum == sum){
                    printContinuoutSequence(small, big);
                }
            }
            big++;
            curSum += big;
        }
    }

    public static void printContinuoutSequence(int small, int big){
        for (int i = small; i <= big; i++){
            System.out.print(i);
            if (i != big)
                System.out.print("-");
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
        findContinuousSequence(15);
    }
}
