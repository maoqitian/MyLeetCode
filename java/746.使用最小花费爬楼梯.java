/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        //贪心 动态规划 使用原数组 记录每步花费
        //时间复杂度 O(n)
        // 0 1 位置依据题意可以看做相等
        int len = cost.length;

        for(int i = 2;i < len;i++){
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }

        return Math.min(cost[len-2],cost[len-1]);
    }
}
// @lc code=end

