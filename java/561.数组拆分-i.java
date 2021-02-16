/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {

        //排序 获取 数组下标偶数位和 时间复杂度 O(n)

        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i< nums.length; i = i+2){
           sum += nums[i];
        }

        return sum;

    }
}
// @lc code=end

