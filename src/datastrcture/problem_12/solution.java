package datastrcture.problem_12;




public class solution {
    public static int minNumberRotateArray(int [] array){
        // 日常判断
        if (array.length == 0)
            return 0;

        // 用两个指针分别指向数组的第一个元素和最后一个元素
        int begin = 0;
        int end = array.length - 1;
        int mid = (end + begin)/2 + begin;
        int result = -1;

        while (begin < end){
            if (begin == (end-1)){
                result = array[end];
                break;
            }
            // 如果第一个指针与第二个指针指向的值相同，不得不采用顺序查找
            if (array[begin] == array[mid] && array[mid] == array[end]){
                result = findMin(array);
                break;
            /*
            如果中间元素大于或等于第一个指针指向的元素，那么该中间元素
            位于前面的子数组，我们把第一个指针指向该中间元素，这样缩小
            范围。
             */
            }else if (array[mid] >= array[begin]){
                begin = mid;
             /*
            同理继续缩小范围。
             */
            }else if (array[mid] <= array[end]){
                end = mid;
            }
            mid = (end - begin)/2 + begin;
        }
        return result;
    }

    public static int findMin(int[] array){
        int result = -1;
        for (int i=0;i<(array.length-1);i++){
            if (array[i]>array[i+1]){
                result = array[i+1];
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(minNumberRotateArray(new int[]{4,5,6,7,8,1,2,3}));
        System.out.println(minNumberRotateArray(new int[]{1,0,1,1,1}));
    }
}
