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
        for (boolean bool:visited){
            bool = false;
        }
        int count = movingCountCore(k, rows, cols, 0, 0, visited);

        return count;
    }

    private static int movingCountCore(int k, int rows, int cols, int row, int col, boolean[] visited){
        int count = 0;
        if (check(k, rows, cols, row, col, visited) == true){
            visited[row*cols + col] = true;

            count = 1 + movingCountCore(k, rows, cols, row-1, col, visited)
                      + movingCountCore(k, rows, cols, row, col-1, visited)
                      + movingCountCore(k, rows, cols, row+1, col, visited)
                      + movingCountCore(k, rows, cols, row, col+1, visited);
        }
        return count;
    }

    private static boolean check(int k, int rows, int cols, int row, int col, boolean[] visited){
        System.out.println(row);
        if (row >= 0 &&
            row < rows &&
            col >= 0 &&
            col <= cols &&
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
        System.out.println(movingCount(6,3,3));
    }
}
