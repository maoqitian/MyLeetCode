/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {

        //同时记录 最大值和最小值，当数组的值为负值，则最大值变成最小值，最小值变成最大值
        //时间复杂度 O(n)


        int max = Integer.MIN_VALUE,imin = 1,imax=1;
        for (int i = 0; i < nums.length; i++) {
            
             if(nums[i]<0){ //如果为负数 交换 imax 和 imin值
               int temp = imax;
               imax = imin;
               imin = temp;
            }

            imax = Math.max(imax *nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(imax, max);

        }

        return max;

    }
}
// @lc code=end

