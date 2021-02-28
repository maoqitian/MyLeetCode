/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        //使用两个状态量 a=1 b=1 来标识目前是单调递增还是递减
        //时间复杂度 O(n)
        //数组元素2 以内 可以保证不管是单调递增还是递减
        int len = A.length;

        if(len <=2) return true;

        int a = 0,b = 0;

        for(int i = 0; i< len -1 ;i++){
           if(A[i] < A[i+1]) a = 1;
           if(A[i] > A[i+1]) b = 1;
        }

        return a+b != 2;

    }
}
// @lc code=end

