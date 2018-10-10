<link href="markdown.css" rel="stylesheet"></link>

## 第一个只出现一次的字符
> 题目一:字符串中第一个只出现一次的字符。
 
&emsp;&emsp; 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"， 则输出'b'。
> 解题思路： 

```java
class solution{
    // 哈希表
    public static char firstNotRepeatingChar(String str){
        if (str == null)
            return '\0';
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(char c : str.toCharArray()){
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
            index++;
        }
        return '\0';
    }
}
```
