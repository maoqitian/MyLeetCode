/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {

        int len = 0;

        for(int i : nums){
           if(i != val){
               nums[len++] = i;
           }
        }

        return len;

    }
}
// @lc code=end

