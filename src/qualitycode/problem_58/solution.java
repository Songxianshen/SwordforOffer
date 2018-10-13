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
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(("I am a student."));
        reverseStentence(sb);
        System.out.println(sb);
    }
}
