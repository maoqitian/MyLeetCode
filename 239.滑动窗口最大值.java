/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        // 滑动窗口 思想为使用队列

        //方法一 暴力法 遍历每个窗口的最大值  时间复杂度 O(nk) n为数组中元素个数

        if (nums.length * k == 0) return new int[0];

        int [] output = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                max = Math.max(max, nums[j]); 
            }
            output[i]= max;
        }
        return output;
    }
}
// @lc code=end

