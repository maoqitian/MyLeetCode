/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {

        //二分查找 时间复杂度 O(logn)

        int left = 0,right = nums.length;

        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid+1;
            }
        }

         return left;
    }
}
// @lc code=end

