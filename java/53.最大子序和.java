/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
         //动态规划
        //dp[i] 代表当前计算中的最大和
        //动态规划方程
        //dp[i] = Max(dp[i-1]+nums[i],nums[i])

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int  maxres = dp[0];

        for (int i = 1; i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            //更新最大值
            maxres = Math.max(dp[i],maxres);
        }

        return maxres;

    }
}
// @lc code=end

