/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if( len == 0) return 0;

        int[][] dp = new int[k+1][2];

        for(int i = 1;i <= k;i++){
            dp[i][1] = Integer.MIN_VALUE;
        }

        for(int price : prices){
           for(int j =1;j <= k;j++){
                dp[j][0] = Math.max(dp[j][0],dp[j][1]+price);
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0] - price);

           }
        }

        return dp[k][0];
    }
}
// @lc code=end

