package qualitycode.problem_29;
public class solution {
    /**
     * 打印矩阵
     */
    public static void printMatrixClockwisely(int[][] numbers, int columns, int rows){

        if (numbers == null || columns <= 0 || rows <= 0)
            return;

        int start = 0;
        while (columns > start * 2 && rows > start * 2 ){
            printMatrixInCircle(numbers,4,4,start);
            start ++;
        }
    }

    public static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start){
        int endX = columns - start - 1;
        int endY = rows - start -1;

        // 从左到右打印一行
        for (int i=start;i<=endX;i++){
            int number = numbers[start][i];
            System.out.print(number+", ");
        }

        // 从上到下打印一列
        if (start < endY){
            for (int i=start+1;i<=endY;i++){
                int number = numbers[i][endX];
                System.out.print(number+", ");
            }
        }

        // 从右往左打印一行
        if (start < endX && start < endY){
            for (int i=endX-1;i>=start;i--){
                int number = numbers[endY][i];
                System.out.print(number+", ");
            }
        }

        // 从下往上打印一行
        if (start < endY-1 && start < endX){
            for (int i=endY-1;i>=start+1;i--){
                int number = numbers[i][start];
                System.out.print(number+", ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };
        printMatrixClockwisely(matrix,4,4);

    }
}
