/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        //二分查找

        int left = 0,right = nums.length -1;

        while(left < right){


            //求出中间值 
            int mid = (left+right) /2;
            //折中值在数组范围 左边范围
            if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])){
                left = mid + 1;
            }else if(target > nums[mid] && target < nums[0]){
                left = mid +1;
            }else{
                right = mid;
            }
        }

        return left == right && nums[left] == target ? left : -1;



    }
}
// @lc code=end

