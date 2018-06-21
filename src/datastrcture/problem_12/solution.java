package datastrcture.problem_12;




public class solution {
    /**
     *
     * @param matrix  输入矩阵
     * @param rows    矩阵行数
     * @param cols    矩阵列数
     * @param str     要搜索的字符串
     * @return        是否找到
     */
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
                if (findPath(matrix,i,j,rows,cols,0,visited,str)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 回溯搜索算法
     * @param matrix   输入矩阵
     * @param row      当前处理行号
     * @param col      当前处理列好
     * @param rows     矩阵行数
     * @param cols     矩阵列数
     * @param k        已经处理str中字符串的个数
     * @param visited  访问标记数组
     * @param str      要搜索的字符串
     * @return
     */
    public static boolean findPath(char [] matrix, int row, int col, int rows, int cols,
                            int k ,boolean[] visited, char[] str){
        if (row<0 || row>= rows || col<0 || col>cols || str[k] != matrix[row*col+col]){
            return false;
        }

        if (k == str.length - 1){
            return true;
        }
        visited[row*cols+col] = true;
        if (findPath(matrix,row+1,col,rows,cols,k+1,visited,str) ||
            findPath(matrix,row,col+1,rows,cols,k+1,visited,str) ||
            findPath(matrix,row-1,col,rows,cols,k+1,visited,str) ||
            findPath(matrix,row,col-1,rows,cols,k+1,visited,str))
        {
            return true;
        }
        visited[row*cols+col] = false;
        return false;
    }
}
