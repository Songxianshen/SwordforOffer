package others;

public class fib {
    public static int RectCover(int target) {
        int[] result = new int[]{0, 1, 2};
        if(target < 3){
            return result[target];
        }
        int num = 0;
        int numMinusOne = 2;
        int numMinusTwo = 1;
        for(int i=3;i<=target;i++){
            num = numMinusOne + numMinusTwo;
            numMinusTwo = numMinusOne;
            numMinusOne = num;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(RectCover(2));
    }
}
