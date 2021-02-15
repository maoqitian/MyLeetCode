/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int res = -1;
        int count = 0;
        for(int i = 0 ; i < nums.length;i++){
           if(nums[i] == 1){
              count += 1;
           }else {
              count = 0;
           }
           res = Math.max(res,count); 
        }

        return res;

    }
}
// @lc code=end

