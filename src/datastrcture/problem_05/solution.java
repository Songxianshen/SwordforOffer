package datastrcture.problem_05;

public class solution {


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



    /*
        时间复杂度为O(n),利用StringBuffer实现
     */
    public static String replaceSpace(StringBuffer str){
        if (str == null){
            return null;
        }
        int fromIndex = 0;
        int index = 0;
        StringBuffer temp = new StringBuffer();
        while (index<=str.length()){
            index = str.indexOf(" ", fromIndex);
            if (index >= 0){
                temp.append(str.subSequence(fromIndex, index)).append("%20");
                index = index + 1;
                fromIndex = index;
            }else {
                temp.append(str.subSequence(fromIndex, str.length()));
                break;
            }
        }
        return temp.toString();

    }



    public static void main(String[] args) {

        System.out.println(replaceSpace(" an xiang xi huan li chao".toCharArray()));
    }
}
