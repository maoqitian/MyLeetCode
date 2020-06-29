/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {

        if(nums.length == 0){
           return 0;
        }

        int min = Integer.MAX_VALUE;

        //循环嵌套
        //方法一 两个for 循环 累加 时间复杂度 O(n^2)
        
        // for (int i = 0; i < nums.length; i++) {
        //     int sum = nums[i];
        //     if(sum >= s) return 1;
        //     for (int j = i+1; j < nums.length; j++) {
        //         sum += nums[j]; 
        //         if(sum >= s){
        //             //如果相加和满足条件
        //             min = Math.min(min, j-i+1);
        //         }
        //     }
        // }
        // return min == Integer.MAX_VALUE ? 0 : min;
        //方法二 滑动窗口 时间复杂度 O(n)
        //窗口左右边界 
        int left = 0,right = 0,sum = 0;

        while(right < nums.length){

            sum += nums[right++];

            while(sum >= s){
                min = Math.min(min,right - left);
                //移动滑动窗口组左边界
                sum -= nums[left++];
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;

    }
}
// @lc code=end

