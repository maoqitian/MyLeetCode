/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //方法一 暴力破解 时间复杂度 O (n^2)
        int[] a = new int[2];
        for(int i =0 ; i<= nums.length-1;i ++){
           for(int j = i+1;j<= nums.length;j ++){
              if(nums[i]+nums[j] == target){
                a[0] = nums[i];
                a[1] = nums[j];
                return a;
              }
           }
        }
        return a;
    }
}
// @lc code=end

