/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心索引
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {

        //对于中心索引必然有：sum = total - sum - nums[i] （左边值 = 右边值）
        int total = 0,sum = 0;
        if(nums.length<1) return -1;
        for(int i : nums){
           total += i;
        }

        for(int i = 0;i< nums.length;i++){
            if( sum == total -sum - nums[i]){
                return i;
            }
            sum += nums[i];
        }

        return -1;


    }
}
// @lc code=end

