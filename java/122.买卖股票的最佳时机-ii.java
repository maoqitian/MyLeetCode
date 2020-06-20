/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        // 贪心算法 假定知道第二天的结果

        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            //如果今天的估值大于昨天 ，卖出计算收益
            if(prices[i] > prices[i-1]){
              max = max + (prices[i]-prices[i-1]);
            }
        }

        return max;        
    }
}
// @lc code=end

