/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] A) {

        //每次遍历同时更新最大值  A[i] + A[j] + i - j  = A[i] + i + A[j] -j
        // 遍历同时也可以保存A[i]+i 他们的下标 和 值都是一一对应的
        //时间复杂度 O(n)

        int res =0, mx = A[0] + 0;
        for (int j = 1; j< A.length; j++) {
            res = Math.max(res, mx + A[j]-j);
            mx = Math.max(mx, A[j]+j); //更新A[i] + i的最大值
        }

        return res;
    }
}
// @lc code=end

