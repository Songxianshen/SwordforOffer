<link href="markdown.css" rel="stylesheet"></link>

## 翻转字符串
> 题目一: 翻转单词顺序
   
 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为了简单起见，标点符号和普通字母一样处理。  
 例如：输入字符串`"I am a student."`，则输出为`"student. a am I"`。
> 解题思路：     

第一步翻转句子中所有的字符。比如翻转`"I am a student."`中所有的字符得到`".tneduts a ma I"`，此时不但翻转了句子中单词的顺序，
连单词内的字符顺序也被翻转了。  
第二步再翻转每个单词中字符的顺序，就得到了`"student. a am I"`。

```java
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
```
> 题目二: 左旋转字符串
   
字符串的左旋转操作是把字符串前面的若干字符转移到字符串的尾部。请定义一个函数实现
字符串左旋转的功能。比如，输入字符串`"abcdefg"`和数字2，该函数将返回两位得到的结果`"cdefgab"`。
> 解题思路：     


```java



