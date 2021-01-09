/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        //时间复杂度 O(n)
        /**
        对于任意一天考虑四个变量:
        firstBuy: 在该天第一次买入股票可获得的最大收益 
        firstSell: 在该天第一次卖出股票可获得的最大收益
        secondBuy: 在该天第二次买入股票可获得的最大收益
        secondSell: 在该天第二次卖出股票可获得的最大收益
        分别对四个变量进行相应的更新, 最后secSell就是最大
        收益值(secSell >= fstSell)
        **/
        int firstBuy = Integer.MIN_VALUE,secondBuy = Integer.MIN_VALUE;
        int firstSell = 0,secondSell = 0;
        for(int price : prices){
            firstBuy = Math.max(firstBuy,-price);
            firstSell = Math.max(firstSell,firstBuy+price);
            secondBuy = Math.max(secondBuy,firstSell - price);
            secondSell = Math.max(secondSell,secondBuy+price);
        }

        return secondSell;

    }
}
// @lc code=end

