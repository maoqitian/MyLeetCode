/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {

        //贪心算法 时间复杂度 O(n) 
        //从后往前遍历数组 记录当前能够到达最后的位置下标

        if(nums == null) return false;

        //记录最后能够到达的下标 index
        int endReachable = nums.length-1;
        for (int i = nums.length-1; i >= 0; i--) {
            if(nums[i]+i >= endReachable){
                // 当前位置与值和大于等于最后能够到达最后位置下标 记录当前index
               endReachable = i;
            }
        }
        //如果endReachable 记录位置为数组第一个元素下标 说明可以到达
        return endReachable == 0;

    }
}
// @lc code=end

