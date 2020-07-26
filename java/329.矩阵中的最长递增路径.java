/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        //动态规划 时间复杂度 O(mn) mn为行列长度
        //返回值
        int res = 0;
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
               res = Math.max(res,helper(matrix,new Integer[matrix.length][matrix[0].length],i,j));
            }
        }

        return res;
    
    }
    
    int helper(int[][] matrix, Integer[][] dp, int row, int col){
        if(dp[row][col] != null) return dp[row][col];
        int res = 1,rows = dp.length,cols = matrix[0].length;
        if(row != 0 && matrix[row-1][col] > matrix[row][col]){
            res = Math.max(res,1+helper(matrix,dp,row-1,col));
        }
        if(col != 0 && matrix[row][col-1] > matrix[row][col]){
            res = Math.max(res,1+helper(matrix,dp,row,col-1));
        }
        if(row != rows-1 && matrix[row+1][col] > matrix[row][col]){
            res = Math.max(res,1+helper(matrix,dp,row+1,col));
        }
        if(col != cols-1 && matrix[row][col+1] > matrix[row][col]){
            res = Math.max(res,1+helper(matrix,dp,row,col+1));
        }
        return dp[row][col]=res;
    }
}
// @lc code=end

