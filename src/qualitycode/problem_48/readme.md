<link href="markdown.css" rel="stylesheet"></link>

## 最长不含重复字符的子字符串
> 题目:
 
&emsp;&emsp;请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含了
`'a'~'z'`的字符。例如，在字符串`"arabcacfr"`中，最长的不含重复字符的子字符串是`"acfr"`，长度为4。
> 解题思路： 

* 利用动态规划
1. 首先定义函数`f(i)`表示第i个字符为结尾的不包含重复字符的字符串的最长长度。我们从左到右逐一扫描字符串中每个字符。当我们计算
`f(i)`时，我们已经知道`f(i-1)`了。
2. 如果的i个字符之前没有出现过，那么`f(i)=f(i-1)+1`，如果第i个字符已经出现过，那情况要复杂点了。我们先计算第i个字符和它上次出现
在字符串中的距离，并记为d，接着分两种情形分析：  
a. 如果`d>f(i-1)`，此时第i个字符上次出现在`f(i-1)`对应的最长字符串之前，因此任然有`f(i)=f(i-1)+1`。    
b. 如果`d<=f(i-1)`，此时第i个字符上次出现在`f(i-1)`对应的最长子字符串之中，因此`f(i)=d`。同时意味着在第i个字符出现两次所夹的字符串中 
没有其他重复字符了。  

这样我们可以得到每一个字符为结尾的不包含重复字符的子字符串的最大长度，并记录下来。在代码中我们用maxLength记录不包含重复字符的子字符串的最大长度，
我们使用了一个HashMap来记录每个字符是否出现和它出现的位置。
```java
class solution{
    public static int longestSubstringWithoutDuplication(String str){
        int currentLength = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap();
        for (int i=0;i<str.length()-1;i++){
            char c = str.charAt(i);
            if (!map.containsKey(c) || i-map.get(c) > currentLength){
                currentLength++;
            }else{
                if (currentLength > maxLength) maxLength = currentLength;
                currentLength = i - map.get(c);
            }
            map.put(c,i);
        }
        if (currentLength>maxLength) maxLength=currentLength;
        return maxLength;
    }
}
```
* 利用快慢指针

1. 定义两个指针指向首个字符，慢指针不动，快指针先走，每走一步，判断快指针在HashSet中是否存在，不存在，存储字符信息并继续走，直到快指针
指向重复字符串；
2. 若此时快指针-慢指针>已经记录的字符串长度，更新字符串长度；
3. 快指针不动，慢指针开始走，每走一步，将HashSet中对应的字符信息删除，直至快慢指针所指的字符相同（此时快慢指针依旧是错开的，慢指针指向
快指针这个字符出现的第一次，快指针指向的是字符出现的第二次），此时不删除该字符的信息，慢指针直接++；
4. 重复1、2、3，直至快指针走到字符串尾，当指针指向尾，再判断一次步骤2，返回子串长度。

```java
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
}
```