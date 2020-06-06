/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] output = new int[nums.length];

        int k = 1;
        
        //获取左边相乘的结果

        for (int i = 0; i < output.length; i++) {
            output[i] = k; //k为该数左边的乘积。刚开始左边没有乘积 所以为 1
            k = k * nums[i]; //此时数组存储的是除去当前元素左边的元素乘积
        }

        //右边相乘

        k =1;

        for(int i = nums.length-1;i>=0;i--){
           output[i] = output[i]*k; //k为该数右边的乘积。刚开始右边没有乘积 所以为 1
           k = k * nums[i]; //此时数组等于左边的 * 该数右边的
        }

        return output;

    }
}
// @lc code=end

