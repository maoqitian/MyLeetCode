/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        //想法一 暴力破解 将二维数组降为一维数组 时间复杂度 O(m*n)

        if(matrix.length ==0) return false;

        int row = matrix.length,columns = matrix[0].length;

        int []res = new int[row*columns];
        //遍历二维数组子数组index
        int index=0;
        for (int[] temps : matrix) {
            for (int i : temps) {
                res[index++] = i;
            }
        }

        for (int i : res) {
            if(i == target) return true;
        }

        return false;

        //想法二 二分查找 
    }
}
// @lc code=end

