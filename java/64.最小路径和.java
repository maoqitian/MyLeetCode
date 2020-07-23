/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {

        //动态规划 时间复杂度 O(nm)
        //状态转移方程
        // dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length;
        int m = grid[0].length;

        int [][]dp = new int[n][m];

        dp[0][0] = grid[0][0];

        //行 赋值
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0]; 
        }
        //列 赋值
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j]; 
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j]+ Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
}
// @lc code=end

