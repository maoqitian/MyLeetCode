/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {

        //动态规划 参考 https://leetcode.com/problems/burst-balloons/discuss/733279/For-Beginner.-Intutive-NEVER-coufused-again-with-complete-explanations-and-demo.
        //时间复杂度 O(n^3)
        
        if(nums == null || nums.length == 0)return 0;

        int lenght = nums.length;
        int [][]dp = new int[lenght][lenght];

        //自顶向上 气球从无到有

        for (int i = lenght-1; i >= 0; i--) {
            for (int j = i; j <=lenght-1; j++) {
                for (int k= i; k <= j; k++) {

                    int val = 0;
                    val += (k== i)? 0: dp[i][k-1];
                    val += (k== j)? 0: dp[k+1][j];

                    //计算值
                    val += ((i == 0)?1:nums[i-1])* nums[k] * ((j == lenght-1)?1:nums[j+1]);
                    dp[i][j] = Math.max(dp[i][j], val);
                }
            }
        }

        return dp[0][lenght-1];

      

    }
}
// @lc code=end

