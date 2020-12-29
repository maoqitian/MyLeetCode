/*
 * @lc app=leetcode.cn id=330 lang=java
 *
 * [330] 按要求补齐数组
 */

// @lc code=start
class Solution {
    public int minPatches(int[] nums, int n) {

         long total = 0;
         int index = 0, count = 0, len = nums.length; 

         while(total < n){

            if(index >= len || total+1 < nums[index]){
                count++;
                total += total+1;
            }else{
                total += nums[index];
                index++;
            }
         }
         return count;
    }
}
// @lc code=end

