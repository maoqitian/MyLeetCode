/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {

         //动态规划 
         if(n<4)return n-1;
         
         int n1 = n/3,n2 = n%3;
         if(n2 == 0) return (int)Math.pow(3,n1);
         if(n2 == 1) return (int)Math.pow(3,n1-1)*4;
         return (int) Math.pow(3,n1)*2;

    }
}
// @lc code=end

