/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {

        //水平翻转 对角线翻转 时间复杂度 O(n^2)
        int length = matrix.length;
        //水平翻转
        for(int i = 0;i<length/2;++i){
           for(int j = 0;j<length;++j){
             int temp = matrix[i][j];
             matrix[i][j] = matrix[length-i-1][j];
             matrix[length-i-1][j] = temp;
           }
        }
        //对角线翻转
        for(int i = 0;i<length;++i){
            for(int j = 0;j<i;++j){
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
            }
         }
    }

    
}
// @lc code=end

