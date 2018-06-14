package datastrcture.problem_10;




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




    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
    }
}
