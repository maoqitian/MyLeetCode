/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {


         //动态规划 自底向上 时间复杂度 O(m*n)

         //创建二位数据记录终点往回路径的和
         int[][]dp = new int[m][n];

         //首先把从终点左边和向上开始的这两行全部填充为1 标识路径只有一条
         for (int i = 0; i < m; i++) dp[i][0] = 1;
         for (int i = 0; i < n; i++) dp[0][i] = 1;


         //根据状态转换方法自底向上累计计算结果
         for (int i = 1; i < m; i++) {
             for (int j = 1; j < n; j++) {
                 dp[i][j] = dp[i-1][j]+dp[i][j-1];
             }
         }
         //返回起点结果
         return dp[m-1][n-1];

    }
}
// @lc code=end

