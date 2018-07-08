<link href="markdown.css" rel="stylesheet"></link>

## 礼物的最大价值
> 题目:

在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都具有一定价值（大于0）。从左上角开始拿礼物，每次向右或想下移动一格，知道右下角
结束。给定一个棋盘，求拿到礼物的最大价值，例如，对于如下棋盘
```
1   10  3   8
12  2   9   6 
5   7   4   11
3   7   16  5
```
 
&emsp;&emsp;
> 解题思路： 

* 动态规划
```java
class solution{
    public static int getMaxValue(int[][] matrix){
        if (matrix==null) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] values = new int[rows][cols];
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                int current = matrix[row][col];
                if (row == 0 && col == 0) values[row][col] = current;
                else if (row == 0 && col != 0) values[row][col] = values[row][col-1] + current;
                else if (col == 0 && row != 0) values[row][col] = values[row-1][col] + current;
                else {
                    values[row][col] = current + Math.max(values[row-1][col], values[row][col-1]);
                }
            }
        }
        return values[rows-1][cols-1];
    }
}
```
* 广度搜索遍历
```java
public class solution {
    public static int getMaxValueWithGraph(int[][] matrix){
        if (matrix == null) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, matrix[0][0]));
        Node cur = null;
        while (!(queue.peek().row == rows-1 && queue.peek().col == cols-1)){
            cur = queue.poll();
            if (cur.row != rows-1)
                queue.offer(new Node(cur.row+1,cur.col,cur.sum+matrix[cur.row+1][cur.col]));
            if (cur.col != cols-1)
                queue.offer(new Node(cur.row,cur.col+1,cur.sum+matrix[cur.row][cur.col+1]));
        }
        int maxSum = 0,temp = 0;
        while (!queue.isEmpty()){
            temp = queue.poll().sum;
            if (temp>maxSum)maxSum=temp;
        }
        return maxSum;

    }
}
class Node{
    int row;
    int col;
    int sum;
    public Node(int row, int col, int sum){
        this.row = row;
        this.col = col;
        this.sum = sum;
    }
}


```
