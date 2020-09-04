/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {

        //动态规划

        int len = nums.length;
        int dp[] = new int[len];

        //初始化 dp 数组
        for(int i= 0;i<len;i++){
           dp[i] = nums[i];
        }

        for(int i = len -2;i>=0;i--){

            for(int j = i+1;j<len;j++){
               dp[j] = Math.max(nums[i] - dp[j],nums[j] - dp[j-1]);
            }
        }
        return dp[len-1]>=0;

    }
}
// @lc code=end

