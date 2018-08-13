package others;

public class problem11 {
    public static int numOf1(int n){
        int count = 0;
        while (n != 0){
            n = n & (n - 1);
            System.out.println(toFullBinaryString(n));
            count ++;
        }
        return count;
    }
    public static String toFullBinaryString(int x){
        int[] buffer = new int[Integer.SIZE];
        for (int i=(Integer.SIZE-1); i>=0; i--){
            buffer[i] = x >> i & 1;
        }
        String s = "";
        for (int j = Integer.SIZE - 1;j>=0;j--){
            s = s+buffer[j];
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(numOf1(100));
//        System.out.println(toFullBinaryString(127));
    }
}
