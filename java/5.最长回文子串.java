/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {


        //左右扩散

        int start =0,end =0;

        for (int i = 0; i < s.length(); i++) {
            //获取当前字符
            char c = s.charAt(i);
            int left =i,right =i;
            while(left >=0 && s.charAt(left) == c){
                left -- ;
            }

            while(right <s.length() && s.charAt(right) == c){
                right ++ ;
            }
            //根据截取判断是否为回文
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) != s.charAt(right)){
                   break;
                }

                left --;
                right ++ ;
            }

            left = left +1;
            if(end -start < right -left){
               start = left;
               end = right;
            }
        }

        return s.substring(start,end);
    }
}
// @lc code=end

