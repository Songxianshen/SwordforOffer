package qualitycode.problem_56;



public class solution {

    public static int findNumberAppearingOnce(int[] numbers){
        int length = numbers.length;
        int[] bitSum = new int[32];
        for (int i=0; i<length; i++){
            int bitMask = 1;
            for (int j=31; j>=0; j--){
                int bit = numbers[i] & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++){
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(findNumberAppearingOnce(new int[]{1,1,1,4,3,3,3,6,6,6,7,7,7}));
    }
}
