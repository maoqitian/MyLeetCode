/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {

        //需要巧妙求解 异或运算 ^
        /**
         *1^1=0
　　      0^0=0
          1^0=1
　　      0^1=1
         */

         //所以例子中 可以变成 2^2^1 = 1
         // 4 ^ 1 ^ 2^ 1 ^ 2 = 4 ^(1^1)^(2^2) = 4

         int res = 0;

         for (int i : nums) {
             res = res ^ i;
         }

         return res;
    }
}
// @lc code=end

