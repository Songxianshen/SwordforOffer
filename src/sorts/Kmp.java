//package sorts;
//
//public class Kmp {
//    private static int[] createPartialMatchTable(String pattern){
//        int patternLength = pattern.length();
//        int[] matchTable = new int[patternLength];
//
//        int i = 0;
//        int matchValue = 0;
//        while(i < patternLength){
//            if (i == 0)matchValue=0;
//            else matchValue =
//        }
//    }
//    private static boolean kmp(String target, String pattern){
//        int[] partialMatchTable = createPartialMatchTable(pattern);
//
//        char[] targetCharArr = target.toCharArray();
//        char[] patternCharArr = pattern.toCharArray();
//        int matchCharCounts = 0;        //记录下已经匹配的字符的个数
//        int i = 0, j = 0, moveCounts = 0;
//        while (i<targetCharArr.length){
//            // 如果主串和子串的字符匹配上了 那么比较下一个字符是否匹配
//            if (targetCharArr[i] == patternCharArr[i]){
//                matchCharCounts++;
//                i++;
//                j++;
//            }
//            // 如果子串的第一个元素不和主串的元素相等 那么就拿主串的下一个元素进行比较
//            else if (j == 0){
//                i++;
//            }
//            // 如果子串不是在第一个元素的位置而是在其他的位置进行了失配，那么进行移位操作
//            else{
//                // 移动位数 = 已匹配字符串 - 对应部分的匹配值
//                // 对应匹配值 指的是最后一个字符的对应匹配值 j是失配的位置 所以这里是partialMatchTable[j-1]
//                moveCounts = matchCharCounts - partialMatchTable[j -1];
//                j = j - moveCounts; // 移动模式串 往前移动moveCounts位
//                matchCharCounts = matchCharCounts - moveCounts;
//            }
//            // 如果匹配成功了 直接返回true了
//            if(j == patternCharArr.length){
//                return true;
//            }
//        }
//        return false;
//    }
//}
