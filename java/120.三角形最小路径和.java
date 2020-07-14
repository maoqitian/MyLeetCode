/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        //经典动态规划题目

        // 方法一：

        //动态规划  dp[i][j] 表示从点 (i, j)(i,j) 到底边的最小路径和 
       //时间复杂度 O(n^2)  空间复杂度 O(n^2)
        //相邻结点：与(i, j) 点相邻的结点为 (i + 1, j) 和 (i + 1, j + 1)。
       //状态转移 dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
       

        // int n = triangle.size();
        // int [][] dp = new int[n+1][n+1];

        // //自顶向上
        // for (int i = n-1; i >=0; i--) {
        //     for (int j = 0; j <= i; j++) {
        //         dp[i][j] =Math.min(dp[i+1][j], dp[i+1][j+1])+triangle.get(i).get(j);
            
        //     }
        // }

        // return dp[0][0];


        //方法二 优化 
        //上面解法计算 dp[i][j]dp[i][j] 时，只用到了下一行的 dp[i + 1][j]dp[i+1][j] 和 dp[i + 1][j + 1]dp[i+1][j+1]。
        //因此 dp 数组不需要定义 N 行，只要定义 1 行也就是一位数组
        //状态转移 dp[j]=min(dp[j],dp[j+1])+triangle[i][j]
        //时间复杂度 O(n^2)  空间复杂度 O(n)
        int n = triangle.size();
        int []dp = new int[n+1];

        //自顶向上
        for (int i = n-1; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] =Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            
            }
        }

        return dp[0];

    }
}
// @lc code=end

