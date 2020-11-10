/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {

        //时间复杂度 O(n)
        int i = nums.length -2;
        //找到 偏小的数 index
        while(i >= 0 && nums[i] >= nums[i+1]){
            i --;
        }

        if(i >= 0){
          int j = nums.length -1;
          while(j >= 0 && nums[i] >= nums[j]){
              j--;
          }
          //替换位置
          swap(nums,i,j);
        }
        //反转数组
        reverse(nums,i+1);
    }

    void swap(int[]nums,int i,int j){
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
    }

    void reverse(int []nums,int start){
       int left = start,right = nums.length-1;
       while(left < right){
            swap(nums,left,right);
            left++;
            right --;
       }
    }
}
// @lc code=end

