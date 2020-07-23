/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {

        // 二分查找 
        if(nums == null || nums.length ==0  )return 0;

        int left = 0,right = nums.length-1;

        while(left < right){
           int mid = left + (right-left)/2;

           if(nums[mid] > nums[right]){
              //说明最小值在右边
              left = mid+1;
           }else if(nums[mid] < nums[right]){
              //最小值在左边
              right = mid;
           }else{
               //如果值相等则无法判断在左还是右 则直接移动右边界
               right -= 1;
           }
        }
        return nums[left];

    }
}
// @lc code=end

