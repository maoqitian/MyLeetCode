/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {

        //二分查找 子数组的最大值是有范围的，即在区间 [max(nums),sum(nums)][max(nums),sum(nums)] 之中
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count <= m;
    }
}
// @lc code=end

