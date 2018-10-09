package qualitycode.problem_48;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solution {
    // 利用快慢指针
    public static int longthOfLongestSubString(String str){
        int count = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet();
        while (end != str.length()){
            if (!set.contains(str.charAt(end))) set.add(str.charAt(end));
            else {
                if (end - start > count) count = end - start;
                while (str.charAt(start) != str.charAt(end)){
                    set.remove(str.charAt(start));
                    start++;
                }
                start++;
            }
            end++;
        }
        if (end - start > count) count = end - start;
        return count;
    }
    // 利用动态规划
    public static int longestSubstringWithoutDuplication(String str){
        int currentLength = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap();
        for (int i=0;i<str.length()-1;i++){
            char c = str.charAt(i);
            if (!map.containsKey(c) || i-map.get(c) > currentLength){
                currentLength++;
            }else{
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = i - map.get(c);
            }
            map.put(c, i);
        }
        if (currentLength>maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("arabcacfr"));
        System.out.println(longthOfLongestSubString("arabcacfr"));
    }
}
