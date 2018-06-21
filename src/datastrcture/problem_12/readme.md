<link href="markdown.css" rel="stylesheet"></link>

## 矩阵中的路径

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵的任意一格开始，每一步可以
在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3x4的
矩阵中包含一条"bfce"的路径。但矩阵中不包含字符串"abfb"的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二格子之后，
路径不能再次进入这个格子。
```html
a   b   t   g
c   f   c   s
j   d   e   h
```
**解题思路：**  

```java
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
```