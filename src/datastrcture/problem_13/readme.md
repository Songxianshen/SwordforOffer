<link href="markdown.css" rel="stylesheet"></link>

## 机器人的运动范围

> 题目：

地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次可以向左、右、上、下移动一格，
但不能进入行坐标和列坐标的数位之和大于k的格子。例如当k为18时，不能进入方格（35，38），因为3+5+3+8=19。请问机器人能够达到多少个格子？  
> 解题思路：
机器人从坐标（0，0）开始移动，当它准备进入坐标为（i，j）的格子时，则再通过检查坐标位数和来判断机器人能否进入，如果机器人能够进入坐标
（i，j）的格子，再判断它能否进入4个相邻的格子（i，j-1）、（i-1，j）、（i，j+1）、（i+1，j）。因此，我们可以用如下的代码来实现回溯
算法。
```java
public class solution {

    /**
     * 计算格子数
     */
    public static int movingCount(int k, int rows, int cols){
        // 日常判断
        if (k<0 || rows<=0 || cols<=0){
            return 0;
        }
        boolean []visited = new boolean[rows*cols];
        int count = movingCountCore(k, rows, cols, 0, 0, visited);

        return count;
    }

    /**
     * 回溯算法
     */
    private static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if (check(k, rows, cols, row, col, visited)){
                visited[row*cols + col] = true;

            count = 1 + movingCountCore(k, rows, cols, row-1, col, visited)
                      + movingCountCore(k, rows, cols, row, col-1, visited)
                      + movingCountCore(k, rows, cols, row+1, col, visited)
                      + movingCountCore(k, rows, cols, row, col+1, visited);
        }
        return count;
    }
    
    /**
     * 检查该格子是否满足条件
     */
    private static boolean check(int k, int rows, int cols, int row, int col, boolean[] visited){
        if (row >= 0 &&
            row < rows &&
            col >= 0 &&
            col < cols &&
            getDigitSum(row) + getDigitSum(col) <= k &&
            visited[row * cols + col] != true){
            return true;
        }
        return false;
    }
    /**
     * 得到一个数字的位数之和
     */
    private static int getDigitSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(movingCount(2,3,3));
    }
}
```