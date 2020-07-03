/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {

        //二分查找 时间复杂度 O(logn)

        int left =0,right = nums.length-1;

        while(right > left){ //当前右边界大于左边界

            int mid = left + (right - left) /2;
 
            if(nums[mid] > nums[right]){ //当前中间值 大于 右边界的值
                //说明最小值在 右半部分
               left= mid+1;
            }else{
                //说明最小值在左半部分
                right = mid;
            }
        }
        //最终左边界指向最小值（原数组升序旋转）
        return nums[left];

    }
}
// @lc code=end

