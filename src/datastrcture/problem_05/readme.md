<link href="markdown.css" rel="stylesheet"></link>

## 替换空格
**题目：替换空格**    

请实现一个函数，把字符串中的每个空格替换成"%20"。
  
例如，输入“We are happy.”,则输出“We%20are%20happy.”。

**解题思路：**    

我们可以先遍历一次字符串，这样就能统计出字符串中空格的总数，并可以由此计算出替换之后的字符串的总长度。每替换一次空格，长度增加2。这样算法的时间九尾复杂度为**On**。
1. 把第一个指针指向字符串的末尾，把第二个指针指向替换之后的字符串的末尾。
2. 依次复制字符串的内容，直至第一个指针碰到第一个空格。
3. 把第一个空格替换成 “%20” ，把第一个指针向前移动 1 格，把第二个指针向前移动 3 格。
4. 依次向前复制字符串中的指针，直至碰到空格。
5. 替换字符串中的倒数第二个空格，把第一个指针向前移动 1 格，把第二个指针向前移动 3 格。

* JAVA实现思想  

从后往前复制，使得数组的长度增加，或者使用StringBuilder、StringBuffer类

```java
public static String replaceSpace(char[] string){
    if(string == null){
        return null;
    }
    int originalLength = string.length;
    int spacecount = 0;
    for(int i = 0;i < originalLength; i++){
        if(string[i] == ' '){
            spacecount++;
        }
    }
    int newLength = originalLength + 2 * spacecount;
    char[] temp = new char[newLength];
    int i = originalLength - 1;
    int j = newLength - 1;
    while (i >= 0){
        if(string[i] == ' '){
            temp[j]='0';
            temp[j-1]='2';
            temp[j-2]='%';
            j -= 3;
        }else{
            temp[j] = string[i];
            j -= 1;
        }
        i -= 1;
    }
    return new String(temp);
}
```

