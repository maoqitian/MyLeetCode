/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {

        //时间复杂度 O（n）
        //递推 一间房 num[0]
        //二间房 max(s0,s1)
        //三间房 max(s1,s0+s2)
        //n间房 max(Sn-1,sn+sn-2)

        if(nums == null || nums.length == 0){
           return 0;
        }
        if(nums.length == 1){
           return nums[0];
        }

        //分别获取 s1 s2
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first+nums[i], second);
            first = temp;
        }

        return second;
         
    }
}
// @lc code=end

