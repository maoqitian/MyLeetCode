/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {

        //对于这类左右对称题目，可以首先想到左右夹逼 时间复杂度 O(n)
        
        int left = 0,right = s.length()-1;

        while(left<= right){
            //题目要求值考虑字母和数字
            if(!Character.isLetterOrDigit(s.charAt(left))){ //如果不是数字或者字母
               left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
               right--;
            }else{
               if(Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right))){
                   //Character.toLowerCase 不区分大小写
                  return false;
               }
               left++;
               right--;
            }

        }
        return true;

    }
}
// @lc code=end

