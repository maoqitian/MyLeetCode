import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {

        //算法 原地 Hash  [1,N] 区间
        // 也就是 遍历一次让 位置  0 存放 1  1存放 2 以此类推
        //第二次遍历数组 当前 位置 0 值不等于 0+1 则返回该位置的 index +1 
        //否则最后返回 数组长度+1 代表最小整数

        int len = nums.length;

        //第一次遍历 尽可能排放在正确位置
        for (int i = 0; i < len; i++) {
            while(nums[i] >=1 && nums[i] <= len && nums[nums[i]-1] != nums[i]){ //当前值在数组区间 并且不在正确的位置 交换到正确的位置
                //将当前值交换到正确的位置
                swap(nums,i,nums[i] -1);
            }
        }
        //第二次遍历
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]-1 != i ){
               return i+1;
            }
        }

        return len+1;
 
    }

    /**
     * 交换两位置值 出现在正确的 index
     * @param nums 数组
     * @param index1 index1
     * @param index2 index2  
     */
    void swap( int[] nums,int index1 ,int index2){

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
// @lc code=end

