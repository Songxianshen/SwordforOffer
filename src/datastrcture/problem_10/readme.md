<link href="markdown.css" rel="stylesheet"></link>

## 斐波那契数列

>题目

写出一个函数，输入 n ，求斐波那契数列的第 n 项。斐波那契数列的定义如下：  
```
      |0                          n = 0
f(n)= |1                          n = 1
      |f(n-1)+f(n-2)              n > 1
```  
>解题思路:

比较简单的办法是从下往上计算，首先根据f(0)和f(1)算出f(2)，再根据f(1)和f(2)算出f(3)，依次类推就可以算出第 n 项了。很容易
理解，这种思路的时间复杂度就是O(n)。实现的代码如下：
 ```java
public class solution {
    /**
     * 不使用递归，使用循环的方法
     * @param n
     * @return
     */
    public static int fibonacci(int n){
        int[] result = {0, 1};
        if(n < 2)
            return result[n];
        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int fibN = 0;
        for(int i=2;i<=n;i++){
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }
}
```