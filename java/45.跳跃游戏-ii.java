/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {

        //时间复杂度 O(n)
        int setp = 0; //需要的步骤

        int end = 0; //当前能够到达的边界 初始为0

        int maxPis = 0;//能够到达的最大最大位置下标
        
        for (int i = 0; i < nums.length-1; i++) {
            maxPis = Math.max(maxPis, nums[i]+i); //nums[i]+i 当前位置的值加上index表达能到达的最远位置

            if(end == i){
                //更新能够达到的最大值
               end = maxPis;
               //步骤加一
               setp++;
            }
        }

        return setp;

    }
}
// @lc code=end

