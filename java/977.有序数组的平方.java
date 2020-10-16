/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {

        //时间复杂度 O(n)
        if(A == null || A.length ==0) return A;

        for(int i= 0;i<A.length;i++){
            int temp = A[i];
            A[i] = temp*temp;
        }

        Arrays.sort(A);

        return A;
    }
}
// @lc code=end

