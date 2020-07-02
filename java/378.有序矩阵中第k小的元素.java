import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第K小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        //想法一 直接 将二维数组降维成一维数组 排序 返回 k-1 数组的值
        //时间复杂度 O(n^2logn)
        //获取 行 和 列的 值
        int row = matrix.length,colum = matrix[0].length;

        int []res = new int[row*colum];

        int index =0;
        for (int[] is : matrix) {
            for (int i : is) {
                res[index++] = i;
            }
        }

        //冒泡排序数组
        // for (int i = 0; i < res.length; i++) {
        //     for (int j = i+1; j < res.length; j++) {
        //         if(res[i]>res[j]){
        //           int temp = res[i];
        //           res[i] = res[j];
        //           res[j] = temp;
        //         }
        //     }
        // }
        //库函数排序 
        Arrays.sort(res);
        return res[k-1];
    }
}
// @lc code=end

