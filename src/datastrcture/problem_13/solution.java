package datastrcture.problem_13;




public class solution {

    /**
     * 计算
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
