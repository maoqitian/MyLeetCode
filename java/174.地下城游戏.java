import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        //动态规划 逆向 dp 时间复杂度 O(m*n)

        int n = dungeon.length,m = dungeon[0].length;

        int [][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[n][m-1] = dp[n-1][m] = 1;

        //逆向
        for (int i = n-1; i >= 0; --i) {
            for (int j = m-1; j >= 0 ; --j) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1); 
            }
        }

        return dp[0][0];
    }
}
// @lc code=end

