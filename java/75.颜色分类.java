/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {

         //方法一 0 1 2 冒泡排序 时间复杂度 O(n^2)
        //  for(int i =0;i< nums.length;i++){
        //     for(int j = 0;j<nums.length;j++){
        //        if(nums[i]<nums[j]){
        //          int temp = nums[i];
        //          nums[i] = nums[j];
        //          nums[j] = temp;
        //        }
        //     }
        //  }
         // 方法二 左右双指针 遇到 O 和 2 交换位置 一次遍历 时间复杂度 O(n)
         
         if (nums == null || nums.length <= 1) {
            return;
        }

         int left = 0,right = nums.length -1;

         for(int i = left ;i <= right;i++){
             if(nums[i] == 0){
                 //替换赋值
                 nums[i] = nums[left];
                 nums[left++] = 0; 
             }else if(nums[i] == 2){
                 nums[i--] = nums[right];
                 nums[right--] = 2;
             }
         }
    }
}
// @lc code=end

