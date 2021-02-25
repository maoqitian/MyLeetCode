/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] matrix) {

        //相当于把 M*N矩阵 转变成 N*M 矩阵 , res[j][i] = matrix[i][j]

        //时间复杂度 O（mn）
        int m = matrix.length,n = matrix[0].length;

        int[][] res = new int[n][m];


        for(int i = 0; i < m;i++){
           for(int j= 0 ; j < n;j++){
              res[j][i] = matrix[i][j];
           }
        }

        return res;

    }
}
// @lc code=end

