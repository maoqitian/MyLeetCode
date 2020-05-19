/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {

        //由题意 可以删除一个字母进行比较，还是使用左右夹逼的算法 其中可以缩进
        //时间复杂度 O（n）

        int left = 0,right = s.length()-1;

        while(left<=right){

           if(s.charAt(left) == s.charAt(right)){
              left++;
              right--;
           }else{

              return delvalidPalindrome(s,left+1,right) || delvalidPalindrome(s,left,right+1); 
           }
        }
        return true;

    }

    private boolean delvalidPalindrome(String s,int left,int right){
         
        while(left<=right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
             }else{
                return false;
             }
        }
        return true;
    }
}
// @lc code=end

