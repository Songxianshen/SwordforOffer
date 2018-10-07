package qualitycode.problem_50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solution {
    // 利用快慢指针
    public static char firstNotRepeatingChar(String str){
        if (str == null)
            return '\0';
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c)){
                int v = map.get(c);
                map.put(c, ++v);
            }else{
                map.put(c, 1);
            }
        }
        int index = 0;
        while (index < str.length()){
            if (map.get(str.charAt(index)) == 1)
                return str.charAt(index);
            index ++;
        }
        return '\0';
    }
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }
}
