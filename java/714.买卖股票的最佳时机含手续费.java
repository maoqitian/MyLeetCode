/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {

        //动态规划 时间复杂度 O(n)
        //一开始也没想明白，参考链接
        //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/jian-dan-dpmiao-dong-gu-piao-mai-mai-by-tejdo/
        int []dp = new int[2];
        //不持股
        dp[0] = 0;
        //持股
        dp[1] = -prices[0];

        for(int i = 2;i<=prices.length;i++){
            //不持股
           dp[0] = Math.max(dp[0],dp[1]+prices[i-1]-fee);
           //持股
           dp[1] = Math.max(dp[1],dp[0]-prices[i-1]);
        }

        return dp[0];

    }
}
// @lc code=end

