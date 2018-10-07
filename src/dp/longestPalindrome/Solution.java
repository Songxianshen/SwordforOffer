package dp.longestPalindrome;

public class Solution {
    public static String longestPalindrome(String s){
        if (s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        int max = 0;
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i <= j; i++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
                if(dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }
}
