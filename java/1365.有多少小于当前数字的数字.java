/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        //嵌套循环 时间复杂度 O(n)
        int length = nums.length;
        int []res = new int[length];
        if(length == 1){
            res[0] = 0;
            return res;
        }
        //记录 有多少大于的数
        int count = 0;
        for(int i= 0;i < length;i++){
           for(int j = 0;j<length;j++){
              if(i == j){
                 continue;
              }else if(nums[i]>nums[j]){
                  count++;
              }
           }
           //记录当前count 值
           res[i] = count;
           //重置
           count = 0;
        }

        return res;
    }
}
// @lc code=end

