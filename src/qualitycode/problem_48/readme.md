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
这样我们可以得到每一个字符为结尾的不包含重复字符的子字符串的最大长度，并记录下来。
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