/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {

        //连续递增 动态规划 nums[index] > nums[index-1]
        //时间复杂度 O(n)

        if(nums.length < 1) return 0;

        int index =0,max = 1;// 开始递增开始 index
        

        for ( int i =1 ;i <nums.length;i++){
            if (nums[i] > nums[i-1]){
                //符合递增
                //计算记录最大长度
                max = Math.max(i - index + 1,max);
            }else{
                index = i;
            }
        }

        return  max;

    }
}
// @lc code=end

