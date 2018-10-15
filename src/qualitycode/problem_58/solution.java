package qualitycode.problem_58;


import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void reverse(StringBuilder str, int begin, int end){
        while (begin < end){
            char temp = str.charAt(begin);
            str.setCharAt(begin, str.charAt(end));
            str.setCharAt(end, temp);

            begin++;
            end--;
        }
    }
    public static void reverseStentence(StringBuilder str){
        if(str == null)
            return;
        int begin = 0;
        int end = str.length() - 1;
        reverse(str, begin, end);
        end = begin = 0;
        while (begin != str.length()){
            if (str.charAt(begin) == ' '){
                begin++;
                end++;
            }else if (end == str.length() || str.charAt(end) == ' '){
                reverse(str, begin, --end);
                begin = ++end;
            }else{
                end++;
            }
        }
    }
    public static String leftRotateString(String str, int n){
        if (str != null){
            StringBuilder sb = new StringBuilder(str);
            int length = sb.length();
            if (length > 0 && n > 0 && n < length){
                int firstStart = 0;
                int firstEnd = n - 1;
                int secondStart = n;
                int secondEnd = length - 1;
                // 翻转字符串的前面n个字符
                reverse(sb, firstStart, firstEnd);
                // 翻转字符串的后面部分
                reverse(sb, secondStart, secondEnd);
                // 翻转整个字符串
                reverse(sb, firstStart, secondEnd);
            }
            return sb.toString();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(leftRotateString("abcedfg", 2));
    }
}
