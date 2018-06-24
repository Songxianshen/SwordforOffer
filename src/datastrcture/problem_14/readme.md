<link href="markdown.css" rel="stylesheet"></link>

## 减绳子  
题目：  
给你一根长度为n的绳子，请把绳子减成m段（m，n都是整数，且m>1并且n>1），每段绳子的长度为k[0],k[1],...,k[m]。
请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？  
例如，当绳子的长度是8时，我们把它剪成2、3、3的三段，此时得到的最大乘积为18。  
**解题思路：**    
* 动态规划

```java
public class solution {
    /**
     * 动态规划求解
     */
    public static int maxProductAfterCutting1(int length){
        if (length < 2)
        if (length == 3)
            return 2;

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i=4;i<=length;i++){
            max = 0;
            for (int j=1;j<i/2;j++){
                int product = products[j] * products[i-j];
                if (max < product){
                    max = product;
                }
            }
        }
        max = products[length];
        return max;
    }
}
```