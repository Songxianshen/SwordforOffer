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

由于我们想把它的前两个字符移到后面，我们就把前两个字符分到第一部分，把后面的字符分到第二部分。
我们先分别翻转这两部分，于是就得到了`"bagfedc"`。接下在翻转整个字符串，得到的`"cdefgab"`刚好就是
把原始字符串左旋转两位的结果。
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
```
面试官在检查与字符串相关的代码时经常会发现两种问题：
一是输入的空指针nullptr时程序会崩溃；
二是内存访问越界问题，也就是试图访问不属于字符串的内存。