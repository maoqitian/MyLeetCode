/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {

        //主要考察排序 使用冒泡排序 时间复杂度 O(n^2)

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                  //交换位置
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j] = temp;
                }
            }
        }

        return nums[nums.length-k];


    }
}
// @lc code=end

