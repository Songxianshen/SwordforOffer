package datastrcture.problem_12;




public class solution {

    public static boolean hadPath(char[] matrix, int rows, int cols, char[] str){

        // 日常写判断
        if(matrix==null || rows<=0 || cols<=0 || str==null){
            return false;
        }

        if (str.length==0)
            return false;

        boolean[] visited = new boolean[matrix.length];

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){

            }
        }
        return false;
    }

    //尝试寻找路径
    public boolean findPath(char [] matrix, int row, int col, int rows, int cols,
                            int k ,boolean[] visited, char[] str){
        if (row<0 || row>= rows || col<0 || col>cols || str[k] != matrix[row*col+col]){
            return false;
        }

    }

    public static void main(String[] args) {
    }
}
