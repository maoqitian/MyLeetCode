/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {

        //动态规划
        int n = nums.length;
        if(n<2) return false;

        int sum = 0,maxNum = 0;

        for(int num : nums){
            sum += num;
            maxNum = Math.max(maxNum,num);
        }

        if(sum % 2 != 0){
           return false;
        }

        int target = sum /2;

        if(maxNum > target) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int i = 0; i < n;i++){
            int num = nums[i];
            for(int j = target;j >= num; -- j){
               dp[j] |= dp[j-num];
            }
        }
        
        return dp[target];

    }
}
// @lc code=end

