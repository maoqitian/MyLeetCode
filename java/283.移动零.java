/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零  思路 迭代 时间复杂度 O（n）
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {

         //定义数组下标
         int index = 0;

         for (int  i = 0; i < nums.length; i++) {
             if(nums[i]!= 0) {
               nums[index] = nums[i];

               if(i != index){
                   //并且把零往后移动
                 nums[i] = 0;
                 
               }
               index++;
             }

         }

    }
}
// @lc code=end

