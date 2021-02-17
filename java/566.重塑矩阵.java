/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        //(i,j)→i×n+j 也就是 将 x 映射到矩阵下标 i = x / n  j = x % n
        //时间复杂度 O（r*c）

        int m = nums.length,n = nums[0].length;

        if(m*n != r*c) return nums;

        int[][] res = new int[r][c];

        for(int i = 0; i< m*n;i++){
            res[i/c][i%c] = nums[i/n][i%n];
        }

        return res;

    }
}
// @lc code=end

